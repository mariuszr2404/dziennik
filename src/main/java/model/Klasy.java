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
@Table(name = "KLASY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klasy.findAll", query = "SELECT k FROM Klasy k"),
    @NamedQuery(name = "Klasy.findByIdklasy", query = "SELECT k FROM Klasy k WHERE k.idklasy = :idklasy"),
    @NamedQuery(name = "Klasy.findByNazwa", query = "SELECT k FROM Klasy k WHERE k.nazwa = :nazwa"),
    @NamedQuery(name = "Klasy.findBySemestr", query = "SELECT k FROM Klasy k WHERE k.semestr = :semestr")})
public class Klasy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKLASY")
    private Integer idklasy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAZWA")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SEMESTR")
    private String semestr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idklasy")
    private Collection<Uczniowie> uczniowieCollection;

    public Klasy() {
    }

    public Klasy(Integer idklasy) {
        this.idklasy = idklasy;
    }

    public Klasy(Integer idklasy, String nazwa, String semestr) {
        this.idklasy = idklasy;
        this.nazwa = nazwa;
        this.semestr = semestr;
    }

    public Integer getIdklasy() {
        return idklasy;
    }

    public void setIdklasy(Integer idklasy) {
        this.idklasy = idklasy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getSemestr() {
        return semestr;
    }

    public void setSemestr(String semestr) {
        this.semestr = semestr;
    }

    @XmlTransient
    public Collection<Uczniowie> getUczniowieCollection() {
        return uczniowieCollection;
    }

    public void setUczniowieCollection(Collection<Uczniowie> uczniowieCollection) {
        this.uczniowieCollection = uczniowieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idklasy != null ? idklasy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klasy)) {
            return false;
        }
        Klasy other = (Klasy) object;
        if ((this.idklasy == null && other.idklasy != null) || (this.idklasy != null && !this.idklasy.equals(other.idklasy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dziennikv5.Klasy[ idklasy=" + idklasy + " ]";
    }
    
}
