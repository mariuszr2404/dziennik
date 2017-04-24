/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Klasy;
import model.Uczniowie;

@ManagedBean(name = "Uczniowie")
@SessionScoped

public class UczniowieController {

    public UczniowieController() {
    }

    @EJB

    UczniowieEJB uczniowieEJB;
    Uczniowie uczniowie;
    String komunikat;
    int value,maxId=0;
    int iducznia, idklasy;
    String imie,nazwisko,plec;
    Date dataUrodzenia;
    
    List<Uczniowie> list;

    public List<Uczniowie> getList() {
//        list = uczniowieEJB.findAll();
        return list;
    }

    public void readAll() {
        list = uczniowieEJB.findAll();
    }

    public void kindofSort() {
        try {
            if (value == 1) {
                list = uczniowieEJB.sortListByImie();
                komunikat = "Pomyslnie przeprowadzono sortowanie po imieniu: ";
            }
            if (value == 2) {
                list = uczniowieEJB.sortListByNazwisko();
                komunikat = "Pomyslnie przeprowadzono sortowanies po nazwisku: ";
            }
            if (value == 3) {
                list = uczniowieEJB.sortListByDataUrodzenia();
                komunikat = "Pomyslnie przeprowadzono sortowanies po dacie urodzenia: ";
            }
            if (value == 4) {
                list = uczniowieEJB.sortListById();
                komunikat = "Pomyslnie przeprowadzono sortowanies po idklasy: ";
            }

        } catch (Exception e) {
            komunikat = "Nie udalo sie przeprowadzic sortowania: ";
        }
    }
    
    public int findMaxId()
    {
        list = uczniowieEJB.findAll();
        for(int i=0;i<list.size();i++)
        {
            maxId ++;
        }
        
        return maxId + 1;
    }
    
    public void createUczen()
    {
        Uczniowie u = new Uczniowie();
        Klasy k  = new Klasy();
        k.setIdklasy(idklasy);
        u.setIducznia(findMaxId());
        u.setIdklasy(k.getIdklasy());
        u.setImie(imie);
        u.setNazwisko(nazwisko);
        u.setPlec(plec);
        u.setDataurodzenia(dataUrodzenia);
        
        try {
            uczniowieEJB.addUczen(u);
            komunikat = "Udalo sie dodac ucznia: ";
        } catch (Exception e) {
            komunikat = "Nie udana proba dodania rekordu: ";
        }
    }

    public String getKomunikat() {
        return komunikat;
    }

    public void setKomunikat(String komunikat) {
        this.komunikat = komunikat;
    }

    public void setList(List<Uczniowie> list) {
        this.list = list;
    }

    public UczniowieEJB getUczniowieEJB() {
        return uczniowieEJB;
    }

    public void setUczniowieEJB(UczniowieEJB uczniowieEJB) {
        this.uczniowieEJB = uczniowieEJB;
    }

    public Uczniowie getUczniowie() {
        return uczniowie;
    }

    public void setUczniowie(Uczniowie uczniowie) {
        this.uczniowie = uczniowie;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIducznia() {
        return iducznia;
    }

    public void setIducznia(int iducznia) {
        this.iducznia = iducznia;
    }

    public int getIdklasy() {
        return idklasy;
    }

    public void setIdklasy(int idklasy) {
        this.idklasy = idklasy;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }
    
}
