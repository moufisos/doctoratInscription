/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mohammedoufi
 */
@Entity
@Table(name = "branche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branche.findAll", query = "SELECT b FROM Branche b"),
    @NamedQuery(name = "Branche.findById", query = "SELECT b FROM Branche b WHERE b.id = :id"),
    @NamedQuery(name = "Branche.findByIntitule", query = "SELECT b FROM Branche b WHERE b.intitule = :intitule"),
    @NamedQuery(name = "Branche.findByDescription", query = "SELECT b FROM Branche b WHERE b.description = :description")})
public class Branche implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Size(min = 1, max = 45)
    @Column(name = "intitule")
    private String intitule;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "brancheid")
    private Collection<Sujet> sujetCollection;

    public Branche() {
    }

    public Branche(Integer id) {
        this.id = id;
    }

    public Branche(Integer id, String intitule) {
        this.id = id;
        this.intitule = intitule;
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
    
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Sujet> getSujetCollection() {
        return sujetCollection;
    }

    public void setSujetCollection(Collection<Sujet> sujetCollection) {
        this.sujetCollection = sujetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branche)) {
            return false;
        }
        Branche other = (Branche) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.inscdoc.Branche[ id=" + id + " ]";
    }
    
}
