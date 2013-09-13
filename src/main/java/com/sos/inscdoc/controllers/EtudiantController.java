/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.controllers;

import com.sos.inscdoc.entities.Etudiant;
import com.sos.inscdoc.services.EtudiantFacade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author mohammedoufi
 */
@Named(value = "etudiantController")
@SessionScoped
public class EtudiantController implements Serializable{
    
    @Inject
    private EtudiantFacade etudiantService;
    private Etudiant current = new Etudiant();
    private List<Etudiant> etudiant;

    /**
     * Creates a new instance of EtudiantController
     */
    public EtudiantController() {
    }

    public Etudiant getCurrent() {
        return current;
    }

    public void setCurrent(Etudiant current) {
        this.current = current;
    }
    
    public String showEdit(Etudiant etudiant){
        current = etudiant;
    return "edit?faces-redirect=true";
    }
    
    public List<Etudiant> getAll(){
        return etudiantService.findAll();
    }
    
    public String doCreate(){
        etudiantService.create(current);
    return "list?faces-redirect";
    }
    
    public String doUpdate(){
        
        etudiantService.edit(current);
        return "list?faces-redirect";
    }
    
}
