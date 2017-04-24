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
@Table(name = "PRZEDMIOTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Przedmioty.findAll", query = "SELECT p FROM Przedmioty p"),
    @NamedQuery(name = "Przedmioty.findByIdprzedmiotu", query = "SELECT p FROM Przedmioty p WHERE p.idprzedmiotu = :idprzedmiotu"),
    @NamedQuery(name = "Przedmioty.findByNazwa", query = "SELECT p FROM Przedmioty p WHERE p.nazwa = :nazwa")})
public class Przedmioty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRZEDMIOTU")
    private Integer idprzedmiotu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NAZWA")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprzedmiotu")
    private Collection<Nieobecnosci> nieobecnosciCollection;

    public Przedmioty() {
    }

    public Przedmioty(Integer idprzedmiotu) {
        this.idprzedmiotu = idprzedmiotu;
    }

    public Przedmioty(Integer idprzedmiotu, String nazwa) {
        this.idprzedmiotu = idprzedmiotu;
        this.nazwa = nazwa;
    }

    public Integer getIdprzedmiotu() {
        return idprzedmiotu;
    }

    public void setIdprzedmiotu(Integer idprzedmiotu) {
        this.idprzedmiotu = idprzedmiotu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<Nieobecnosci> getNieobecnosciCollection() {
        return nieobecnosciCollection;
    }

    public void setNieobecnosciCollection(Collection<Nieobecnosci> nieobecnosciCollection) {
        this.nieobecnosciCollection = nieobecnosciCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprzedmiotu != null ? idprzedmiotu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Przedmioty)) {
            return false;
        }
        Przedmioty other = (Przedmioty) object;
        if ((this.idprzedmiotu == null && other.idprzedmiotu != null) || (this.idprzedmiotu != null && !this.idprzedmiotu.equals(other.idprzedmiotu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dziennikv5.Przedmioty[ idprzedmiotu=" + idprzedmiotu + " ]";
    }
    
}
