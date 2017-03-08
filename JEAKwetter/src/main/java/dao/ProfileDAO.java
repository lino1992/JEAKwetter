/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Profile;
import domain.Role;
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
public class ProfileDAO {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Profile> allProfile(){
        return em.createNamedQuery("Profile.all").getResultList();
    }
    
    public Profile save(Profile p){
        em.persist(p);
        return p;
    }

    public Profile createNewUser(Profile p) {
         return save(p);
    }
    
    public boolean editUsername(int id, String newUsername){
        try {
            Profile user =  em.find(Profile.class, id);
            user.setName(newUsername);
            em.merge(user);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public boolean editProfileBio(int id , String bio){
       try {
            Profile user =  em.find(Profile.class, id);
            user.setBio(bio);
            em.merge(user);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public boolean editProfileLocation(int id , String location){
       try {
            Profile user =  em.find(Profile.class, id);
            user.setLocation(location);
            em.merge(user);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public boolean addFollowing(int id, Profile profile){
        try {
            Profile user =  em.find(Profile.class, id);
            user.addFollowing(profile);
            em.merge(user);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public List<Profile> getAllFollowing(int profileID){
        try{
            List<Profile> result = em.find(Profile.class, profileID).getFollowing();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }
    
    public List<Profile> getAllFollower(int profileID){
        try{
            List<Profile> result = em.createQuery("Select p.* from profile p where t.profile_id = :id").setParameter("id", profileID).getResultList();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }
    
    public List<Tweets> getAllTweets(int profileID){
        try {
            List<Tweets> result = em.find(Profile.class, profileID).getTweets();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }
    
    

    

    
}
