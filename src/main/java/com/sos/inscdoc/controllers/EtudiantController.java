/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.controllers;

import com.sos.inscdoc.entities.Etudiant;
import com.sos.inscdoc.entities.Groups;
import com.sos.inscdoc.services.EtudiantFacade;
import com.sos.inscdoc.services.GroupsFacade;
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
    private Etudiant newEtudiant;
    private List<Etudiant> etudiant;

    private Groups leGroupe = new Groups();
    @Inject
    private GroupsFacade groupsService;
    
    /**
     * Creates a new instance of EtudiantController
     */
    // ======================================
    // = Constructor =
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

    public String showView(Etudiant etudiant) {
        current = etudiant;
        return "view?faces-redirect=true";
    }
    
    public String showList() {
        return "list?faces-redirect=true";
    }

    public String showCreate() {
        newEtudiant = new Etudiant();
        return "add?faces-redirect=true";
    }
    // ======================================
    // = Business Methodes =
    // ======================================

    public List<Etudiant> getAll() {
        return etudiantService.findAll();
    }

    public String doCreate() {
        leGroupe = groupsService.find(1);
        newEtudiant.setGroupsId(leGroupe);
        etudiantService.create(newEtudiant);
        return showList();
    }

    public String doUpdate() {
        etudiantService.edit(current);
        return "list?faces-redirect";
    }
    
    public String doDelete(Etudiant etudiant){
        this.etudiantService.remove(etudiant);
        this.getAll();
        return this.showList();
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

    public Groups getLeGroupe() {
        return leGroupe;
    }

    public void setLeGroupe(Groups leGroupe) {
        this.leGroupe = leGroupe;
    }
    
    
}
