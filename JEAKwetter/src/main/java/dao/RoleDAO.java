/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import domain.Profile;
import domain.Role;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lino_
 */
@Stateless
public class RoleDAO {
    
    @PersistenceContext
    EntityManager em;
    
    public void save(Role role){
        em.persist(role);
    }

    public void createNewRole(Role role) {
        save(role);
    }
    
    public void addRoleToProfile(Role role){
        em.merge(role);
    }
    
    
}
