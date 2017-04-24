/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Oceny;

@ManagedBean(name = "Oceny")
@SessionScoped

public class OcenyController {

    public OcenyController() {

    }

    @EJB

    OcenyEJB ocenyEJB;
    Oceny oceny;
    Date datewystawienia;
    List<Oceny> listaALL;
    List<Oceny> list;

    public List<Oceny> getListaALL() {
        listaALL = ocenyEJB.findAll();
        return listaALL;
    }

    public Date getDatewystawienia() {
        return datewystawienia;
    }

    public void setDatewystawienia(Date datewystawienia) {
        this.datewystawienia = datewystawienia;
    }

    public OcenyEJB getOcenyEJB() {
        return ocenyEJB;
    }

    public List<Oceny> getList() {
        return list;
    }

    public void setList(List<Oceny> list) {
        this.list = list;
    }

    public void setOcenyEJB(OcenyEJB ocenyEJB) {
        this.ocenyEJB = ocenyEJB;
    }

    public Oceny getOceny() {
        return oceny;
    }

    public void setOceny(Oceny oceny) {
        this.oceny = oceny;
    }

}
