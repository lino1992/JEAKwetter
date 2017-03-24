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
import javax.persistence.Query;

/**
 *
 * @author lino_
 */
@Stateless
public class ProfileDAO {
    
    @PersistenceContext
    EntityManager em;

    public ProfileDAO() {
        //Lege contructor
    }

    public ProfileDAO(EntityManager em) {
        this.em = em;
    }
    
    public List<Profile> allProfile(){
        return em.createNamedQuery("Profile.all").getResultList();
    }
    
    public Profile getProfileById(int id){
        try{
            Long longId = new Long(id);
            return em.find(Profile.class, longId);
        }catch (Exception e){
            return null;
        }
    }
    public Profile createNewUser(Profile p) {
        try{
           em.persist(p);
           em.flush();
           return em.find(Profile.class, p.getId()); 
        }catch (Exception e) {
            return null;
        }
    }
    
    public boolean editUsername(int id, String newUsername){
        try {
            Profile user =  getProfileById(id);
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
           Profile user =  getProfileById(id);
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
           Profile user =  getProfileById(id);
            user.setLocation(location);
            em.merge(user);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public boolean addFollowing(int id, int followingID){
        try {
            Profile user =  getProfileById(id);
            Profile following  = getProfileById(followingID);
            boolean check = user.addFollowing(following);
            if(check){
                em.merge(user);
                return true;
            }
            return false;
            
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public List<Profile> getAllFollowing(int profileID){
        try{
            List<Profile> result = getProfileById(profileID).getFollowing();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }
    
    public List<Profile> getAllFollower(int profileID){
        try{
            Long longId = new Long(profileID);
            Query query = em.createQuery("Select p From profile p, profile_profile p1 where p.ID = p1.owner_ID and p1.following_ID = :id ").setParameter(":id", longId);
            return query.getResultList();
        }
        catch (Exception e){
            return null;
        }
    }
    
    public List<Tweets> getAllTweets(int profileID){
        try {
            Long longId = new Long(profileID);
            List<Tweets> result = em.find(Profile.class, longId).getTweets();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean editProfileWebsite(int id, String website) {
        try {
            Profile user =  getProfileById(id);
            user.setWebsite(website);
            em.merge(user);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public void setEntity(EntityManager em) {
        this.em = em;
    }
    
    
    
    

    

    
}
