/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import domain.Profile;
import domain.Role;
import domain.Tweets;
import java.util.ArrayList;
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

    public TweetsDAO() {
    }

    public TweetsDAO(EntityManager em) {
        this.em = em;
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
    
    public Tweets createNewTweets(Tweets tweets) {
        try{
           em.persist(tweets);
           em.flush();
           return em.find(Tweets.class, tweets.getId());
        }catch (Exception e) {
            return null;
        }
    }
    
    public List<Tweets> searchTweets(String hashTag){
        List<Tweets> result = new ArrayList<>();
        try {
            result = em.createQuery("Select t from Tweets t where t.subject = :subject").setParameter("subject", hashTag).getResultList();
            return result;
        }
        catch (Exception e){
            return result;
        }
    }

    public List<Tweets> getTweetsByProfileId(Long id) {
        try{
            List<Tweets> result = em.createNamedQuery("Tweets.byUserId").setParameter("id", id).getResultList();
            return result;
        }catch (Exception ex){
            return null;
        }
    }
    
    public List<Tweets> getAllFollowingTweets(int id){
        try {
            List<Tweets> result = em.createNamedQuery("Tweets.allTweetsFollowing").setParameter("id", id).getResultList();
            return result;
        }catch(Exception e) {
            return null;
        }
    }
    
}
