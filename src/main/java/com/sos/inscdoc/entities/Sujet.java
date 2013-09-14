/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.entities;

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
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mohammedoufi
 */
@Entity
@Table(name = "sujet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sujet.findAll", query = "SELECT s FROM Sujet s"),
    @NamedQuery(name = "Sujet.findById", query = "SELECT s FROM Sujet s WHERE s.id = :id"),
    @NamedQuery(name = "Sujet.findByDescription", query = "SELECT s FROM Sujet s WHERE s.description = :description"),
    @NamedQuery(name = "Sujet.findByNplace", query = "SELECT s FROM Sujet s WHERE s.nplace = :nplace"),
    @NamedQuery(name = "Sujet.findByIntitule", query = "SELECT s FROM Sujet s WHERE s.intitule = :intitule")})
public class Sujet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Version
    @Column(name = "optimistick_lock")
    private int version;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "nplace")
    private Integer nplace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "intitule")
    private String intitule;
    @JoinColumn(name = "brancheid", referencedColumnName = "id")
    @ManyToOne
    private Branche brancheid;

    public Sujet() {
    }

    public Sujet(Integer id) {
        this.id = id;
    }

    public Sujet(Integer id, String intitule) {
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
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNplace() {
        return nplace;
    }

    public void setNplace(Integer nplace) {
        this.nplace = nplace;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Branche getBrancheid() {
        return brancheid;
    }

    public void setBrancheid(Branche brancheid) {
        this.brancheid = brancheid;
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
        if (!(object instanceof Sujet)) {
            return false;
        }
        Sujet other = (Sujet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.inscdoc.Sujet[ id=" + id + " ]";
    }
    
}
