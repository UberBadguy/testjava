/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.UserProfilePagesDTO;
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
public class UserSessionBean {
    @PersistenceContext
    private EntityManager em;
    
    public UserProfilePagesDTO authenticate(String login, String password) {
        UserProfilePagesDTO userProfilePagesDTO = null;
        try {
            userProfilePagesDTO = em.createNamedQuery("Users.authenticate", UserProfilePagesDTO.class)
                    .setParameter("password", password)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return userProfilePagesDTO;
    }
    
}
