/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.BuildingSitesDTO;
import duoc.cl.jee010.miconstructora.dto.DistrictDTO;
import duoc.cl.jee010.miconstructora.entidades.BuildingSite;
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
        BuildingSitesDTO buildingSiteDTO = null;
        try {
            buildingSiteDTO = em.createNamedQuery("BuildingSite.findAll", BuildingSitesDTO.class)
                    .getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return buildingSiteDTO;
    }
    
    public BuildingSitesDTO getBuildingSite(int id){
        BuildingSitesDTO buildingSiteDTO = null;
        try {
            buildingSiteDTO = em.createNamedQuery("BuildingSite.findById", BuildingSitesDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return buildingSiteDTO;
    }
    
    public BuildingSite createBuildingSite(int id, String name, String address, DistrictDTO district, int status){
        BuildingSite buildingSite = new BuildingSite(id, name, address, status);
        buildingSite.setDistrictId(district.getDistrict());
        
        return buildingSite;
    }
    
    public boolean updateBuildingSite(BuildingSitesDTO buildingSite) {
        BuildingSite bs = buildingSite.getBuildingSite();
        try {
            em.merge(bs);
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean addBuildingSite(BuildingSitesDTO buildingSite) {
        BuildingSite bs = buildingSite.getBuildingSite();
        try {
            em.persist(bs);
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
