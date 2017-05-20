/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.ProvinceDTO;
import duoc.cl.jee010.miconstructora.dto.ProvincesDTO;
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
public class ProvinceSessionBean {
    @PersistenceContext
    private EntityManager em;


    public ProvincesDTO allBuildingSites() {
        ProvincesDTO provincesDTO = null;
        try {
            provincesDTO = em.createNamedQuery("Province.findAll", ProvincesDTO.class)
                    .getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return provincesDTO;
    }
    
    public ProvinceDTO getUser(int id){
        ProvinceDTO provinceDTO = null;
        try {
            provinceDTO = em.createNamedQuery("Province.findById", ProvinceDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return provinceDTO;
    }
}
