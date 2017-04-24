/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Konta;
import model.Nauczyciele;

/**
 *
 * @author mariu
 */
@ManagedBean(name = "Konta")
@SessionScoped
//@RequestScoped

public class KontaController {
    
    public KontaController(){
        
    }

    @EJB
    KontaEJB kontaEJB;
    Konta konta;
    Nauczyciele nauczyciel;

    int idkonta, idnauczyciela;
    String username, password, email, komunikat;
    List<Konta> l;

    public String finKontoValidation() {
        l = kontaEJB.findAllUsers();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getUsername().equals(username) && l.get(i).getPassword().equals(password)) {
                nauczyciel = l.get(i).getIdnauczyciela();
                konta = l.get(i);
                idnauczyciela = nauczyciel.getIdnauczyciela();
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("idnauczyciela", idnauczyciela);
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("nauczyciel",nauczyciel);
                return "StronaGlowna";
            }
        }

        komunikat = "Nieporawny username lub password sproboj ponwnie !!!";
        FacesContext.getCurrentInstance().addMessage("indexForm:Username", new FacesMessage("Blad Logowania !!!!", "Nieporawny username lub password sproboj ponwnie !!!"));
        return null;
    }

    public boolean isLoggedIn()
    {
        return nauczyciel != null;
    }
    
    
    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.invalidate();
        nauczyciel = null;
        
        return "index";
    }

//    public void getSessionParametr() {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
//        
//        username = (String)session.getAttribute("username");
//        password = (String)session.getAttribute("password");
//        idnauczyciela = (int) session.getAttribute("idnauczyciela");
//        
//    }

    public String rejestracja() {
        clearInput();
        clearKomunikat();
        Konta k = new Konta();
        Nauczyciele n = new Nauczyciele();
        n.setIdnauczyciela(idnauczyciela);
        k.setIdkonta(idkonta);
        k.setEmail(email);
        k.setPassword(password);
        k.setUsername(username);
        k.setIdnauczyciela(n);

        try {
            kontaEJB.addKonto(k);
            komunikat = "Pomyslnie udalo sie zalozyc konto, Możesz sie teraz zalogować: ";
            return "index";
        } catch (Exception e) {
            clearInput();
            komunikat = "Nie udalo sie zalozyc kont, sprobój ponownie.";
            FacesContext.getCurrentInstance().addMessage("reform:reform", new FacesMessage("Blad Rejestracji !!!!", "Nieporawny dane prosze wpisac ponownie!!!"));
        }

        return "rejestracja";
    }

    public void clearInput() {
        idkonta = 0;
        idnauczyciela = 0;
        email = "";
        password = "";
        username = "";
    }

    public void clearKomunikat() {
        komunikat = "";
    }

    public KontaEJB getKontaEJB() {
        return kontaEJB;
    }

    public void setKontaEJB(KontaEJB kontaEJB) {
        this.kontaEJB = kontaEJB;
    }

    public Konta getKonta() {
        return konta;
    }

    public void setKonta(Konta konta) {
        this.konta = konta;
    }

    public Nauczyciele getNauczyciel() {
        return nauczyciel;
    }

    public void setNauczyciel(Nauczyciele nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

    public int getIdkonta() {
        return idkonta;
    }

    public void setIdkonta(int idkonta) {
        this.idkonta = idkonta;
    }

    public int getIdnauczyciela() {
        return idnauczyciela;
    }

    public void setIdnauczyciela(int idnauczyciela) {
        this.idnauczyciela = idnauczyciela;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKomunikat() {
        return komunikat;
    }

    public void setKomunikat(String komunikat) {
        this.komunikat = komunikat;
    }

    public List<Konta> getL() {
        return l;
    }

    public void setL(List<Konta> l) {
        this.l = l;
    }

}
