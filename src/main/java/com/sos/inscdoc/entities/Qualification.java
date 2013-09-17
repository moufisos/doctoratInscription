/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.entities;

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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mohammedoufi
 */
@Entity
@Table(name = "qualification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualification.findAll", query = "SELECT q FROM Qualification q"),
    @NamedQuery(name = "Qualification.findById", query = "SELECT q FROM Qualification q WHERE q.id = :id"),
    @NamedQuery(name = "Qualification.findByPartiedelivrante", query = "SELECT q FROM Qualification q WHERE q.partieDelivrante = :partiedelivrante"),
    @NamedQuery(name = "Qualification.findByMension", query = "SELECT q FROM Qualification q WHERE q.mension = :mension"),
    @NamedQuery(name = "Qualification.findByDateobtention", query = "SELECT q FROM Qualification q WHERE q.dateObtention = :dateobtention"),
    @NamedQuery(name = "Qualification.findByDiplome", query = "SELECT q FROM Qualification q WHERE q.diplome = :diplome"),
    @NamedQuery(name = "Qualification.findByDesciptiondipolme", query = "SELECT q FROM Qualification q WHERE q.desciptionDipolme = :desciptiondipolme"),
    @NamedQuery(name = "Qualification.findByClassement", query = "SELECT q FROM Qualification q WHERE q.classement = :classement"),
    @NamedQuery(name = "Qualification.findByNote1", query = "SELECT q FROM Qualification q WHERE q.note1 = :note1"),
    @NamedQuery(name = "Qualification.findByNote2", query = "SELECT q FROM Qualification q WHERE q.note2 = :note2"),
    @NamedQuery(name = "Qualification.findByNote3", query = "SELECT q FROM Qualification q WHERE q.note3 = :note3"),
    @NamedQuery(name = "Qualification.findByNote4", query = "SELECT q FROM Qualification q WHERE q.note4 = :note4"),
    @NamedQuery(name = "Qualification.findByNote5", query = "SELECT q FROM Qualification q WHERE q.note5 = :note5"),
    @NamedQuery(name = "Qualification.findByNote6", query = "SELECT q FROM Qualification q WHERE q.note6 = :note6"),
    @NamedQuery(name = "Qualification.findByDateinscription", query = "SELECT q FROM Qualification q WHERE q.dateInscription = :dateinscription")})
public class Qualification implements Serializable {
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
    @Column(name = "partiedelivrante")
    private String partieDelivrante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mension")
    private String mension;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateobtention")
    @Temporal(TemporalType.DATE)
    private Date dateObtention;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "diplome")
    private String diplome;
    @Size(max = 255)
    @Column(name = "desciptiondipolme")
    private String desciptionDipolme;
    @Column(name = "classement")
    private Integer classement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note1")
    private float note1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note2")
    private float note2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note3")
    private float note3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note4")
    private float note4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note5")
    private float note5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note6")
    private float note6;
    @Column(name = "dateinscription")
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @JoinColumn(name = "etudiantid", referencedColumnName = "id")
    @ManyToOne
    private Etudiant etudiantId;

    public Qualification() {
    }

    public Qualification(Integer id) {
        this.id = id;
    }

    public Qualification(Integer id, String partiedelivrante, String mension, Date dateobtention, String dplome, float note1, float note2, float note3, float note4, float note5, float note6) {
        this.id = id;
        this.partieDelivrante = partiedelivrante;
        this.mension = mension;
        this.dateObtention = dateobtention;
        this.diplome = dplome;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
        this.note5 = note5;
        this.note6 = note6;
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

    public String getPartieDelivrante() {
        return partieDelivrante;
    }

    public void setPartieDelivrante(String partieDelivrante) {
        this.partieDelivrante = partieDelivrante;
    }

    public String getMension() {
        return mension;
    }

    public void setMension(String mension) {
        this.mension = mension;
    }

    public Date getDateobtention() {
        return dateObtention;
    }

    public void setDateobtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }

    public String getDplome() {
        return diplome;
    }

    public void setDplome(String dplome) {
        this.diplome = dplome;
    }

    public String getDesciptionDipolme() {
        return desciptionDipolme;
    }

    public void setDesciptiondipolme(String desciptionDipolme) {
        this.desciptionDipolme = desciptionDipolme;
    }

    public Integer getClassement() {
        return classement;
    }

    public void setClassement(Integer classement) {
        this.classement = classement;
    }

    public float getNote1() {
        return note1;
    }

    public void setNote1(float note1) {
        this.note1 = note1;
    }

    public float getNote2() {
        return note2;
    }

    public void setNote2(float note2) {
        this.note2 = note2;
    }

    public float getNote3() {
        return note3;
    }

    public void setNote3(float note3) {
        this.note3 = note3;
    }

    public float getNote4() {
        return note4;
    }

    public void setNote4(float note4) {
        this.note4 = note4;
    }

    public float getNote5() {
        return note5;
    }

    public void setNote5(float note5) {
        this.note5 = note5;
    }

    public float getNote6() {
        return note6;
    }

    public void setNote6(float note6) {
        this.note6 = note6;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Etudiant getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Etudiant etudiantId) {
        this.etudiantId = etudiantId;
    }

    public Date getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
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
        if (!(object instanceof Qualification)) {
            return false;
        }
        Qualification other = (Qualification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.inscdoc.Qualification[ id=" + id + " ]";
    }
    
}
