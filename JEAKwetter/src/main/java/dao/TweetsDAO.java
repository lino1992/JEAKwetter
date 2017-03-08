/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import domain.Tweets;
import java.util.List;
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

    public void createNewTweets(Tweets tweets) {
        save(tweets);
    }
    
    public boolean deleteTweets(int tweetsId){
        try{
            Tweets tempResult = em.find(Tweets.class, tweetsId);
            em.remove(tempResult);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    
    public List<Tweets> getAllTweetsWithComplains(){
        try {
            List <Tweets> result = em.createQuery("Select t from tweets t where t.Complain = 1").getResultList();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }
    
}
