/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import domain.Profile;
import domain.Role;
import java.util.List;
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
    
    public Role createNewRole(Role role) {
        
        try{
           em.persist(role);
           em.flush();
           return em.find(Role.class, role.getGroupName());
        }catch (Exception e) {
            return null;
        }
    }
    
    public boolean addRoleToProfile(Role role){
       try {
           em.merge(role);
           return true;
       }
       catch (Exception e) {
           return false;
       }
    }

    public List<Role> getAllRole() {
        return em.createNamedQuery("Role.all").getResultList();
    }
    
    
}
