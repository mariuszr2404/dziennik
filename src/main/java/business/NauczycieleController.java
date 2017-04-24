/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Nauczyciele;

@ManagedBean(name = "Nauczyciele")
@SessionScoped
//@RequestScoped
public class NauczycieleController {

    @EJB

    NauczycieleEJB nauczycieleEJB;
    Nauczyciele nauczyciele;
    List<Nauczyciele> l;

    String username, password;
    int idnauczyciela;

    public void sessionResults() {
        l = nauczycieleEJB.findAllNauczyciele();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        username = (String) session.getAttribute("username");
        password = (String) session.getAttribute("password");
        idnauczyciela = (int) session.getAttribute("idnauczyciela");
        
        getPassword();
        getUsername();
        getIdnauczyciela();

    }

    public void setL(List<Nauczyciele> l) {
        this.l = l;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdnauczyciela(int idnauczyciela) {
        this.idnauczyciela = idnauczyciela;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getIdnauczyciela() {
        return idnauczyciela;
    }

    public NauczycieleEJB getNauczycieleEJB() {
        return nauczycieleEJB;
    }

    public void setNauczycieleEJB(NauczycieleEJB nauczycieleEJB) {
        this.nauczycieleEJB = nauczycieleEJB;
    }

    public Nauczyciele getNauczyciele() {
        return nauczyciele;
    }

    public void setNauczyciele(Nauczyciele nauczyciele) {
        this.nauczyciele = nauczyciele;
    }

}
