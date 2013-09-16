/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.controllers;

import com.sos.inscdoc.entities.Branche;
import com.sos.inscdoc.services.BrancheFacade;
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
@Named(value = "brancheController")
@SessionScoped
public class BrancheController implements Serializable{
    @Inject
    private BrancheFacade brancheService;
    private Branche newBranche = new Branche(); 
    private Branche current = new Branche(); 
    private List<Branche> branche;
    /**
     * Creates a new instance of BrancheController
     */
    public BrancheController() {
    }

    public Branche getNewBranche() {
        return newBranche;
    }

    public void setNewBranche(Branche newBranche) {
        this.newBranche = newBranche;
    }

    public List<Branche> getBranche() {
        return branche;
    }

    public void setBranche(List<Branche> branche) {
        this.branche = branche;
    }
    
    public String ShowList(){
     return "list?faces-redirect=true";
    }
    
    public String ShowEdit(Branche current){
        this.current = current;
        return "edit?faces-redirect=true";
    }
    
    public String showCreate(Branche newBranche){
        this.newBranche = newBranche;
        return "add?faces-redirect=true";
    }
    
     public List<Branche> getAll() {
        return brancheService.findAll();
    }
    
    public String doCreate(Branche newBranche){
        brancheService.create(newBranche);
        return "list?faces-redirect=true";
    }
    
    public String doUpdate(Branche current){
        brancheService.edit(current);
        return "list?faces-redirect=true";
    }
    
    
}
