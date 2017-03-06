/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import domain.Tweets;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lino_
 */
@Stateless
public class TweetsDAO {
    
    @PersistenceContext
    EntityManager em;
    
    public void save(Tweets tweets){
        em.persist(tweets);
    }

    public void createNewUser(Tweets tweets) {
        save(tweets);
    }
    
}
