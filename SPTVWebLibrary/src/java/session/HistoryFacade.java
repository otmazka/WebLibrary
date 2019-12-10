/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.History;
import entity.Reader;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class HistoryFacade extends AbstractFacade<History> {

    @PersistenceContext(unitName = "SPTVWebLibraryPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoryFacade() {
        super(History.class);
    }

    public List<History> findTakeBooks() {
    try{
        return em.createQuery("SELECT history FROM History history WHERE history.endDate=NULL")
                .getResultList();
    }catch (Exception e){
        return null;
    }
    }

    public List<History> findNotReturnBooks(Reader reader) {
        try{
        return em.createQuery("SELECT h FROM History h WHERE h.reader=:reader AND h.endDate = null")
        .setParameter("reader",reader)
        .getResultList();
    }catch (Exception e){
        return null;
    }
    
}}
