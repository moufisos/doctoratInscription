/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.controllers;

import com.sos.inscdoc.entities.Comptes;
import com.sos.inscdoc.entities.Etudiant;
import com.sos.inscdoc.entities.Groupes;
import com.sos.inscdoc.services.ComptesFacade;
import com.sos.inscdoc.services.EtudiantFacade;
import com.sos.inscdoc.services.GroupesFacade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author mohammedoufi
 */
@Named(value = "etudiantController")
@SessionScoped
public class EtudiantController implements Serializable {

    // ======================================
    // = Attributes =
    // ======================================
    @Inject
    private EtudiantFacade etudiantService;
    private Etudiant current = new Etudiant();
    private Etudiant newEtudiant = new Etudiant();
    private List<Etudiant> etudiant;
    
    @Inject
    private ComptesFacade comptesService;
    private Comptes comptes = new Comptes();
    
    @Inject
    private GroupesFacade groupesService;
    private Groupes leGroupe = new Groupes();

    /**
     * Creates a new instance of EtudiantController
     */
    // ======================================
    // = Attributes =
    // ======================================
    public EtudiantController() {
    }

    // ======================================
    // = Navigations Methodes =
    // ======================================
    public String showEdit(Etudiant etudiant) {
        current = etudiant;
        return "edit?faces-redirect=true";
    }

    public String showList() {
        this.newEtudiant = null;
        return "list?faces-redirect=true";
    }

    public String showCreate() {
        this.newEtudiant = new Etudiant();
        this.comptes = new Comptes();
        this.leGroupe = new Groupes();
        leGroupe = groupesService.find(1);
        return "add?faces-redirect=true";
    }
    // ======================================
    // = Business Methodes =
    // ======================================

    public List<Etudiant> getAll() {
        return etudiantService.findAll();
    }

    public String doCreate() {
        this.comptes.setCne(newEtudiant.getCne());
        this.comptes.setEmail(newEtudiant.getEmail());
        this.comptes.setLeGroupe(leGroupe);
        comptesService.create(comptes);
        
        
        etudiantService.create(newEtudiant);
        return showList();
    }

    public String doUpdate() {
        etudiantService.edit(current);
        return "list?faces-redirect";
    }
    // ======================================
    // = getters & setters =
    // ======================================

    public Etudiant getCurrent() {
        return current;
    }

    public void setCurrent(Etudiant current) {
        this.current = current;
    }

    public Etudiant getNewEtudiant() {
        return newEtudiant;
    }

    public void setNewEtudiant(Etudiant newEtudiant) {
        this.newEtudiant = newEtudiant;
    }

    public Comptes getComptes() {
        return comptes;
    }

    public void setComptes(Comptes comptes) {
        this.comptes = comptes;
    }

    public Groupes getLeGroupe() {
        return leGroupe;
    }

    public void setLeGroupe(Groupes leGroupe) {
        this.leGroupe = leGroupe;
    }
    
    
}
