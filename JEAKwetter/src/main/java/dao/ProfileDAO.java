/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lino_
 */
@Stateless
public class ProfileDAO {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Profile> allProfile(){
        return em.createNamedQuery("Profile.all").getResultList();
    }
    
    public void save(Profile p){
        em.persist(p);
    }

    public void createNewUser(Profile p) {
        save(p);
    }
    
}
