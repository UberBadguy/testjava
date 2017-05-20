/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.BuildingSiteDTO;
import duoc.cl.jee010.miconstructora.dto.BuildingSitesDTO;
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
public class BuildingSiteSessionBean {
    @PersistenceContext
    private EntityManager em;


    public BuildingSitesDTO allBuildingSites() {
        BuildingSitesDTO usersDTO = null;
        try {
            usersDTO = em.createNamedQuery("BuildingSite.findAll", BuildingSitesDTO.class)
                    .getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return usersDTO;
    }
    
    public BuildingSiteDTO getUser(int id){
        BuildingSiteDTO buildingSiteDTO = null;
        try {
            buildingSiteDTO = em.createNamedQuery("BuildingSite.findById", BuildingSiteDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return buildingSiteDTO;
    }
}
