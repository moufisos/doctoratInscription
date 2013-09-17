/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.controllers;

import com.sos.inscdoc.entities.Groups;
import com.sos.inscdoc.services.GroupsFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mab.salhi
 */
@Named(value = "groupsController")
@SessionScoped
public class GroupsController implements Serializable{
    // ======================================
    // = Attributes =
    // ======================================
    @Inject
    private GroupsFacade groupsService;
    private Groups current = new Groups();
    private Groups newGroups;
    private List<Groups> groupses;

    /**
     * Creates a new instance of GroupsController
     */
    // ======================================
    // = Constructor =
    // ======================================
    public GroupsController() {
    }

    // ======================================
    // = Navigations Methodes =
    // ======================================
    public String showEdit(Groups groups) {
        current = groups;
        return "edit?faces-redirect=true";
    }

    public String showView(Groups groups) {
        current = groups;
        return "view?faces-redirect=true";
    }
    
    public String showList() {
        return "list?faces-redirect=true";
    }

    public String showCreate() {
        newGroups = new Groups();
        return "add?faces-redirect=true";
    }
    // ======================================
    // = Business Methodes =
    // ======================================

    public List<Groups> getAll() {
        return groupsService.findAll();
    }

    public String doCreate() {
        groupsService.create(newGroups);
        return showList();
    }

    public String doUpdate() {
        groupsService.edit(current);
        return "list?faces-redirect";
    }
    
    public String doDelete(Groups groups){
        this.groupsService.remove(groups);
        this.getAll();
        return this.showList();
    }

    // ======================================
    // = getters & setters =
    // ======================================
    public Groups getCurrent() {
        return current;
    }

    public void setCurrent(Groups current) {
        this.current = current;
    }

    public Groups getNewGroups() {
        return newGroups;
    }

    public void setNewGroups(Groups newGroups) {
        this.newGroups = newGroups;
    }
    
    
}
