/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.persistencia;

import duoc.cl.jee010.miconstructora.dto.UserDTO;
import duoc.cl.jee010.miconstructora.dto.UserProfileDTO;
import duoc.cl.jee010.miconstructora.dto.UsersDTO;
import duoc.cl.jee010.miconstructora.entidades.User;
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
    
    public UserProfileDTO authenticate(String login, String password) {
        UserProfileDTO userProfilePagesDTO = null;
        try {
            userProfilePagesDTO = em.createNamedQuery("Users.authenticate", UserProfileDTO.class)
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

    public UsersDTO allUsers() {
        UsersDTO usersDTO = null;
        try {
            usersDTO = em.createNamedQuery("User.findAll", UsersDTO.class)
                    .getSingleResult(); 
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return usersDTO;
    }
    
    public UserDTO getUser(int id){
        UserDTO userDTO = null;
        try {
            userDTO = em.createNamedQuery("User.findById", UserDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw e;
        }
        return userDTO;
    }
}