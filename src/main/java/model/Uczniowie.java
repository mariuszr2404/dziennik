/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariu
 */
@Entity
@Table(name = "UCZNIOWIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uczniowie.findAll", query = "SELECT u FROM Uczniowie u"),
    @NamedQuery(name = "Uczniowie.findByIducznia", query = "SELECT u FROM Uczniowie u WHERE u.iducznia = :iducznia"),
    @NamedQuery(name = "Uczniowie.findByImie", query = "SELECT u FROM Uczniowie u WHERE u.imie = :imie"),
    @NamedQuery(name = "Uczniowie.findByNazwisko", query = "SELECT u FROM Uczniowie u WHERE u.nazwisko = :nazwisko"),
    @NamedQuery(name = "Uczniowie.findByDataurodzenia", query = "SELECT u FROM Uczniowie u WHERE u.dataurodzenia = :dataurodzenia"),
    @NamedQuery(name = "Uczniowie.findByPlec", query = "SELECT u FROM Uczniowie u WHERE u.plec = :plec")})
public class Uczniowie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUCZNIA")
    private Integer iducznia;
    @Size(max = 45)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 60)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Column(name = "DATAURODZENIA")
    @Temporal(TemporalType.DATE)
    private Date dataurodzenia;
    @Size(max = 50)
    @Column(name = "PLEC")
    private String plec;
    @JoinColumn(name = "IDKLASY", referencedColumnName = "IDKLASY")
    @ManyToOne(optional = false)
    private Klasy idklasy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iducznia")
    private Collection<Nieobecnosci> nieobecnosciCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iducznia")
    private Collection<Oceny> ocenyCollection;

    public Uczniowie() {
    }

    public Uczniowie(Integer iducznia) {
        this.iducznia = iducznia;
    }

    public Integer getIducznia() {
        return iducznia;
    }

    public void setIducznia(Integer iducznia) {
        this.iducznia = iducznia;
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

    public Date getDataurodzenia() {
        return dataurodzenia;
    }

    public void setDataurodzenia(Date dataurodzenia) {
        this.dataurodzenia = dataurodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Klasy getIdklasy() {
        return idklasy;
    }

    public void setIdklasy(Klasy idklasy) {
        this.idklasy = idklasy;
    }

    @XmlTransient
    public Collection<Nieobecnosci> getNieobecnosciCollection() {
        return nieobecnosciCollection;
    }

    public void setNieobecnosciCollection(Collection<Nieobecnosci> nieobecnosciCollection) {
        this.nieobecnosciCollection = nieobecnosciCollection;
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
        hash += (iducznia != null ? iducznia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uczniowie)) {
            return false;
        }
        Uczniowie other = (Uczniowie) object;
        if ((this.iducznia == null && other.iducznia != null) || (this.iducznia != null && !this.iducznia.equals(other.iducznia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dziennikv5.Uczniowie[ iducznia=" + iducznia + " ]";
    }

    public void setIdklasy(int idklasy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
