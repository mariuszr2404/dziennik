/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariu
 */
@Entity
@Table(name = "RODZAJEOCEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rodzajeocen.findAll", query = "SELECT r FROM Rodzajeocen r"),
    @NamedQuery(name = "Rodzajeocen.findByIdrodzajuOceny", query = "SELECT r FROM Rodzajeocen r WHERE r.idrodzajuOceny = :idrodzajuOceny"),
    @NamedQuery(name = "Rodzajeocen.findByNazwa", query = "SELECT r FROM Rodzajeocen r WHERE r.nazwa = :nazwa")})
public class Rodzajeocen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRODZAJU_OCENY")
    private Integer idrodzajuOceny;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAZWA")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrodzajuOceny")
    private Collection<Oceny> ocenyCollection;

    public Rodzajeocen() {
    }

    public Rodzajeocen(Integer idrodzajuOceny) {
        this.idrodzajuOceny = idrodzajuOceny;
    }

    public Rodzajeocen(Integer idrodzajuOceny, String nazwa) {
        this.idrodzajuOceny = idrodzajuOceny;
        this.nazwa = nazwa;
    }

    public Integer getIdrodzajuOceny() {
        return idrodzajuOceny;
    }

    public void setIdrodzajuOceny(Integer idrodzajuOceny) {
        this.idrodzajuOceny = idrodzajuOceny;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<Oceny> getOcenyCollection() {
        return ocenyCollection;
    }

    public void setOcenyCollection(Collection<Oceny> ocenyCollection) {
        this.ocenyCollection = ocenyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrodzajuOceny != null ? idrodzajuOceny.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rodzajeocen)) {
            return false;
        }
        Rodzajeocen other = (Rodzajeocen) object;
        if ((this.idrodzajuOceny == null && other.idrodzajuOceny != null) || (this.idrodzajuOceny != null && !this.idrodzajuOceny.equals(other.idrodzajuOceny))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dziennikv5.Rodzajeocen[ idrodzajuOceny=" + idrodzajuOceny + " ]";
    }
    
}
