/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.RegionDTO;
import duoc.cl.jee010.miconstructora.dto.RegionsDTO;
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
public class RegionSessionBean {
    @PersistenceContext
    private EntityManager em;

    public RegionsDTO allRegions() {
        RegionsDTO regionsDTO = null;
        try {
            regionsDTO = em.createNamedQuery("Region.findAll", RegionsDTO.class)
                    .getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return regionsDTO;
    }
    
    public RegionDTO getRegion(int id){
        RegionDTO regionDTO = null;
        try {
            regionDTO = em.createNamedQuery("Region.findById", RegionDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return regionDTO;
    }
}
