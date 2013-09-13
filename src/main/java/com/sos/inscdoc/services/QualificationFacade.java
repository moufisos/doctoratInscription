/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.inscdoc.services;

import com.sos.inscdoc.entities.Qualification;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mohammedoufi
 */
@Stateless
public class QualificationFacade extends AbstractFacade<Qualification> {
    @PersistenceContext(unitName = "com.sos_inscDoc_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QualificationFacade() {
        super(Qualification.class);
    }
    
}
