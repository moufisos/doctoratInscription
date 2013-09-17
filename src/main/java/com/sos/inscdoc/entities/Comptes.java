/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abdel
 */
@Entity
@Table(name = "comptes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comptes.findAll", query = "SELECT c FROM Comptes c"),
    @NamedQuery(name = "Comptes.findById", query = "SELECT c FROM Comptes c WHERE c.id = :id"),
    @NamedQuery(name = "Comptes.findBycne", query = "SELECT c FROM Comptes c WHERE c.cne = :cne"),
    @NamedQuery(name = "Comptes.findByPassword", query = "SELECT c FROM Comptes c WHERE c.password = :password"),
    @NamedQuery(name = "Comptes.findByEmail", query = "SELECT c FROM Comptes c WHERE c.email = :email")})

public class Comptes implements Serializable {
    private static final long serialVersionUID = 1L;
    /**************
    ***Attributes**
    ***************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Version
    @Column(name = "optimistick_lock")
    private int version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cne")
    private int cne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intitule", referencedColumnName = "intitule")
    private Groupes leGroupe;
    
    public Comptes() {
    }

    public Comptes(int cne, String password, String email) {
        this.cne = cne;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCne() {
        return cne;
    }

    public void setCne(int cne) {
        this.cne = cne;
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

    public Groupes getLeGroupe() {
        return leGroupe;
    }

    public void setLeGroupe(Groupes leGroupe) {
        this.leGroupe = leGroupe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + this.version;
        hash = 23 * hash + Objects.hashCode(this.cne);
        hash = 23 * hash + Objects.hashCode(this.password);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.leGroupe);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comptes other = (Comptes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        if (!Objects.equals(this.cne, other.cne)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.leGroupe, other.leGroupe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comptes{" + "id=" + id + ", version=" + version + ", cne=" + cne + ", password=" + password + ", email=" + email + ", leGroupe=" + leGroupe + '}';
    }
    

    
    
}
