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
    private Etudiant curent = new Etudiant();
    private List<Etudiant> etudiant;

    /**
     * Creates a new instance of EtudiantController
     */
    public EtudiantController() {
    }

    public Etudiant getCurent() {
        return curent;
    }

    public void setCurent(Etudiant curent) {
        this.curent = curent;
    }
    
    
    public List<Etudiant> getAll(){
        return etudiantService.findAll();
    }
    
    public String doCreate(){
        etudiantService.create(curent);
    return "list?faces-redirect";
    }
    
}
