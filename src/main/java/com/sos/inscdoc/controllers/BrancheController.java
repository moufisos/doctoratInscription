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
    private Branche newBranche;
    private Branche current = new Branche(); 
    private List<Branche> branche;
    /**
     * Creates a new instance of BrancheController
     */
    public BrancheController() {
    }

    public Branche getCurrent() {
        return current;
    }

    public void setCurrent(Branche current) {
        this.current = current;
    }
    
    
    public Branche getNewBranche() {
        return newBranche;
    }

    public void setNewBranche(Branche newBranche) {
        this.newBranche = newBranche;
    }

    
    public String showList(){
     return "list?faces-redirect=true";
    }
    
    public String showEdit(Branche branche){
        current = branche;
        return "edit?faces-redirect=true";
    }
    
   public String showCreate(){
        newBranche = new Branche();
        return "add?faces-redirect=true";
    }
    
     public List<Branche> getAll() {
        return brancheService.findAll();
    }
    
    public String doCreate(){
        brancheService.create(newBranche);
        return showList();
    }
    
    public String doUpdate(){
        brancheService.edit(current);
        return showList();
    }
    
    
}
