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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "NIEOBECNOSCI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nieobecnosci.findAll", query = "SELECT n FROM Nieobecnosci n"),
    @NamedQuery(name = "Nieobecnosci.findByIdnieobecnosci", query = "SELECT n FROM Nieobecnosci n WHERE n.idnieobecnosci = :idnieobecnosci"),
    @NamedQuery(name = "Nieobecnosci.findByDataNieobecnosci", query = "SELECT n FROM Nieobecnosci n WHERE n.dataNieobecnosci = :dataNieobecnosci")})
public class Nieobecnosci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDNIEOBECNOSCI")
    private Integer idnieobecnosci;
    @Column(name = "DATA_NIEOBECNOSCI")
    @Temporal(TemporalType.DATE)
    private Date dataNieobecnosci;
    @JoinColumn(name = "IDUCZNIA", referencedColumnName = "IDUCZNIA")
    @ManyToOne(optional = false)
    private Uczniowie iducznia;
    @JoinColumn(name = "IDPRZEDMIOTU", referencedColumnName = "IDPRZEDMIOTU")
    @ManyToOne(optional = false)
    private Przedmioty idprzedmiotu;
    @JoinColumn(name = "IDNAUCZYCIELA", referencedColumnName = "IDNAUCZYCIELA")
    @ManyToOne(optional = false)
    private Nauczyciele idnauczyciela;

    public Nieobecnosci() {
    }

    public Nieobecnosci(Integer idnieobecnosci) {
        this.idnieobecnosci = idnieobecnosci;
    }

    public Integer getIdnieobecnosci() {
        return idnieobecnosci;
    }

    public void setIdnieobecnosci(Integer idnieobecnosci) {
        this.idnieobecnosci = idnieobecnosci;
    }

    public Date getDataNieobecnosci() {
        return dataNieobecnosci;
    }

    public void setDataNieobecnosci(Date dataNieobecnosci) {
        this.dataNieobecnosci = dataNieobecnosci;
    }

    public Uczniowie getIducznia() {
        return iducznia;
    }

    public void setIducznia(Uczniowie iducznia) {
        this.iducznia = iducznia;
    }

    public Przedmioty getIdprzedmiotu() {
        return idprzedmiotu;
    }

    public void setIdprzedmiotu(Przedmioty idprzedmiotu) {
        this.idprzedmiotu = idprzedmiotu;
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
        hash += (idnieobecnosci != null ? idnieobecnosci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nieobecnosci)) {
            return false;
        }
        Nieobecnosci other = (Nieobecnosci) object;
        if ((this.idnieobecnosci == null && other.idnieobecnosci != null) || (this.idnieobecnosci != null && !this.idnieobecnosci.equals(other.idnieobecnosci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dziennikv5.Nieobecnosci[ idnieobecnosci=" + idnieobecnosci + " ]";
    }
    
}
