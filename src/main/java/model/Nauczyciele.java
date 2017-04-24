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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name = "NAUCZYCIELE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nauczyciele.findAll", query = "SELECT n FROM Nauczyciele n"),
    @NamedQuery(name = "Nauczyciele.findByIdnauczyciela", query = "SELECT n FROM Nauczyciele n WHERE n.idnauczyciela = :idnauczyciela"),
    @NamedQuery(name = "Nauczyciele.findByImie", query = "SELECT n FROM Nauczyciele n WHERE n.imie = :imie"),
    @NamedQuery(name = "Nauczyciele.findByNazwisko", query = "SELECT n FROM Nauczyciele n WHERE n.nazwisko = :nazwisko")})
public class Nauczyciele implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDNAUCZYCIELA")
    private Integer idnauczyciela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "IMIE")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnauczyciela")
    private Collection<Konta> kontaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnauczyciela")
    private Collection<Nieobecnosci> nieobecnosciCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idnauczyciela")
    private Collection<Oceny> ocenyCollection;

    public Nauczyciele() {
    }

    public Nauczyciele(Integer idnauczyciela) {
        this.idnauczyciela = idnauczyciela;
    }

    public Nauczyciele(Integer idnauczyciela, String imie, String nazwisko) {
        this.idnauczyciela = idnauczyciela;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Integer getIdnauczyciela() {
        return idnauczyciela;
    }

    public void setIdnauczyciela(Integer idnauczyciela) {
        this.idnauczyciela = idnauczyciela;
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

    @XmlTransient
    public Collection<Konta> getKontaCollection() {
        return kontaCollection;
    }

    public void setKontaCollection(Collection<Konta> kontaCollection) {
        this.kontaCollection = kontaCollection;
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
        hash += (idnauczyciela != null ? idnauczyciela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nauczyciele)) {
            return false;
        }
        Nauczyciele other = (Nauczyciele) object;
        if ((this.idnauczyciela == null && other.idnauczyciela != null) || (this.idnauczyciela != null && !this.idnauczyciela.equals(other.idnauczyciela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dziennikv5.Nauczyciele[ idnauczyciela=" + idnauczyciela + " ]";
    }
    
}
