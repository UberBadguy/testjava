/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.PagesDTO;
import duoc.cl.jee010.miconstructora.entidades.Page;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cetecom
 */
@Stateless
public class PageSessionBean {
    @PersistenceContext
    private EntityManager em;
    
    public PagesDTO getPages( int profile_id) {
        PagesDTO pagesDTO = null;
        try {
            pagesDTO = em.createNamedQuery("ProfilesPage.findByProfile", PagesDTO.class)
                    .setParameter("id", profile_id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return pagesDTO;
    }
    
    public PagesDTO allPages() {
        PagesDTO pagesDTO = null;
        try {
            pagesDTO = em.createNamedQuery("Page.findAll", PagesDTO.class)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return pagesDTO;
    }
    
    public PagesDTO getPage(int id){
        PagesDTO pagesDTO = null;
        try {
            pagesDTO = em.createNamedQuery("Page.findById", PagesDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return pagesDTO;
    }
    
    public PagesDTO getAllAvailableParents() {
        PagesDTO pagesDTO = null;
        try {
            pagesDTO = em.createNamedQuery("Page.findAllAvailableParents", PagesDTO.class)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return pagesDTO;
    }
    
    public Page createBuildingSite(int id, String name, String icon, String path, int parent, int status){
        Page page = new Page(id, name, icon, path, parent, status);
        
        return page;
    }
    
    public boolean updatePage(PagesDTO pagesDTO) {
        Page page = pagesDTO.getPage();
        try {
            em.merge(page);
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean addPage(PagesDTO pagesDTO) {
        Page page = pagesDTO.getPage();
        try {
            em.persist(page);
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
