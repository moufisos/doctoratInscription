/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.controllers;

import com.sos.inscdoc.entities.Sujet;
import com.sos.inscdoc.services.SujetFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mohammedoufi
 */
@Named(value = "sujetController")
@SessionScoped
public class SujetController implements Serializable {

@Inject
private SujetFacade sujetService;
private Sujet current = new Sujet() ;
private Sujet newSujet;
private List<Sujet> sujets;
    
    /**
     * Creates a new instance of SujetController
     */
    public SujetController() {
    }
    
    public List<Sujet> getAll(){
    return sujetService.findAll();
    }

    public Sujet getCurrent() {
        return current;
    }

    public void setCurrent(Sujet current) {
        this.current = current;
    }

    public Sujet getNewSujet() {
        return newSujet;
    }

    public void setNewSujet(Sujet newSujet) {
        this.newSujet = newSujet;
    }
    
    public String showEdit(Sujet sujet){
    current = sujet;
    return "edit?faces-redirect=true";
    }
    
    public String showCreate(){
     newSujet = new Sujet();
     return "add?faces-redirect=true";
    }
    
    public String showList(){
        return "list?faces-redirect=true";
    }
    
    
    public String doCreate(){
        System.out.println("subject " + current.getIntitule() + " == " + current.getNplace());
        sujetService.create(newSujet);
        return "list?faces-redirect=true";
    }
    
    public String doUpdate(){
        sujetService.edit(current);
        return "list?faces-redirect";
    }
}
