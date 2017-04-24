/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariu
 */
@Entity
@Table(name = "KONTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Konta.findAll", query = "SELECT k FROM Konta k"),
    @NamedQuery(name = "Konta.findByIdkonta", query = "SELECT k FROM Konta k WHERE k.idkonta = :idkonta"),
    @NamedQuery(name = "Konta.findByUsername", query = "SELECT k FROM Konta k WHERE k.username = :username"),
    @NamedQuery(name = "Konta.findByPassword", query = "SELECT k FROM Konta k WHERE k.password = :password"),
    @NamedQuery(name = "Konta.findByEmail", query = "SELECT k FROM Konta k WHERE k.email = :email")})
public class Konta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKONTA")
    private Integer idkonta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PASSWORD")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "IDNAUCZYCIELA", referencedColumnName = "IDNAUCZYCIELA")
    @OneToOne(optional = false)
    private Nauczyciele idnauczyciela;

    public Konta() {
    }

    public Konta(Integer idkonta) {
        this.idkonta = idkonta;
    }

    public Konta(Integer idkonta, String username, String password, String email) {
        this.idkonta = idkonta;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getIdkonta() {
        return idkonta;
    }

    public void setIdkonta(Integer idkonta) {
        this.idkonta = idkonta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (idkonta != null ? idkonta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Konta)) {
            return false;
        }
        Konta other = (Konta) object;
        if ((this.idkonta == null && other.idkonta != null) || (this.idkonta != null && !this.idkonta.equals(other.idkonta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.dziennikv5.Konta[ idkonta=" + idkonta + " ]";
    }
    
}
