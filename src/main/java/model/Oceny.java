/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariu
 */
@Entity
@Table(name = "OCENY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oceny.findAll", query = "SELECT o FROM Oceny o"),
    @NamedQuery(name = "Oceny.findByIdoceny", query = "SELECT o FROM Oceny o WHERE o.idoceny = :idoceny"),
    @NamedQuery(name = "Oceny.findByOcena", query = "SELECT o FROM Oceny o WHERE o.ocena = :ocena"),
    @NamedQuery(name = "Oceny.findByDatawystawienia", query = "SELECT o FROM Oceny o WHERE o.datawystawienia = :datawystawienia")})
public class Oceny implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOCENY")
    private Integer idoceny;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OCENA")
    private int ocena;
    @Column(name = "DATAWYSTAWIENIA")
    @Temporal(TemporalType.DATE)
    private Date datawystawienia;
    @JoinColumn(name = "IDUCZNIA", referencedColumnName = "IDUCZNIA")
    @ManyToOne(optional = false)
    private Uczniowie iducznia;
    @JoinColumn(name = "IDRODZAJU_OCENY", referencedColumnName = "IDRODZAJU_OCENY")
    @ManyToOne(optional = false)
    private Rodzajeocen idrodzajuOceny;
    @JoinColumn(name = "IDNAUCZYCIELA", referencedColumnName = "IDNAUCZYCIELA")
    @ManyToOne(optional = false)
    private Nauczyciele idnauczyciela;

    public Oceny() {
    }

    public Oceny(Integer idoceny) {
        this.idoceny = idoceny;
    }

    public Oceny(Integer idoceny, int ocena) {
        this.idoceny = idoceny;
        this.ocena = ocena;
    }

    public Integer getIdoceny() {
        return idoceny;
    }

    public void setIdoceny(Integer idoceny) {
        this.idoceny = idoceny;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Date getDatawystawienia() {
        return datawystawienia;
    }

    public void setDatawystawienia(Date datawystawienia) {
        this.datawystawienia = datawystawienia;
    }

    public Uczniowie getIducznia() {
        return iducznia;
    }

    public void setIducznia(Uczniowie iducznia) {
        this.iducznia = iducznia;
    }

    public Rodzajeocen getIdrodzajuOceny() {
        return idrodzajuOceny;
    }

    public void setIdrodzajuOceny(Rodzajeocen idrodzajuOceny) {
        this.idrodzajuOceny = idrodzajuOceny;
    }

    public Nauczyciele getIdnauczyciela() {
        return idnauczyciela;
    }

    public void setIdnauczyciela(Nauczyciele idnauczyciela) {
        this.idnauczyciela = idnauczyciela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoceny != null ? idoceny.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oceny)) {
            return false;
        }
        Oceny other = (Oceny) object;
        if ((this.idoceny == null && other.idoceny != null) || (this.idoceny != null && !this.idoceny.equals(other.idoceny))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dziennikv5.Oceny[ idoceny=" + idoceny + " ]";
    }
    
}
