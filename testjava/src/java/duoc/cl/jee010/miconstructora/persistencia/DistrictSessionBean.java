/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.DistrictDTO;
import duoc.cl.jee010.miconstructora.dto.DistrictsDTO;
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
public class DistrictSessionBean {
    
    @PersistenceContext
    private EntityManager em;
    

    public DistrictsDTO allDistricts() {
        DistrictsDTO districtsDTO = null;
        try {
            districtsDTO = em.createNamedQuery("District.findAll", DistrictsDTO.class)
                    .getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return districtsDTO;
    }
    
    public DistrictDTO getDistrict(int id){
        DistrictDTO districtDTO = null;
        try {
            districtDTO = em.createNamedQuery("District.findById", DistrictDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return districtDTO;
    }
}
