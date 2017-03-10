/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProfileDAO;
import domain.Profile;
import domain.Role;
import domain.Tweets;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Stateless
public class ProfileService {
    
    @Inject
    ProfileDAO pr;
    
    
    /**
     * 
     * @return 
     */
    public List<Profile> allProfile(){
        return pr.allProfile();
    }
    /**
     * 
     * @param profile
     * @return 
     */
    public Profile createNewUser(Profile profile){
        return pr.createNewUser(profile);
    }
    /**
     * 
     * @param id
     * @param newUsername
     * @return 
     */
    public boolean editUsername(int id, String newUsername){
        return pr.editUsername(id, newUsername);
    }
    /**
     * 
     * @param id
     * @param bio
     * @return 
     */
    public boolean editProfileBio(int id, String bio){
        return pr.editProfileBio(id, bio);
    }
    /**
     * 
     * @param id
     * @param location
     * @return 
     */
    public boolean editProfileLocation(int id , String location){
       return pr.editProfileLocation(id, location);
    }
    /**
     * 
     * @param id
     * @param followingID
     * @return 
     */
    public boolean addFollowing(int id, int followingID){
        return pr.addFollowing(id, followingID);
    }
    /**
     * 
     * @param profileID
     * @return 
     */
    public List<Profile> getAllFollowing(int profileID){
        return pr.getAllFollowing(profileID);
    }
    /**
     * 
     * @param profileID
     * @return 
     */
    public List<Profile> getAllFollower(int profileID){
        return pr.getAllFollowing(profileID);
    }
    /**
     * 
     * @param profileID
     * @return 
     */
    public List<Tweets> getAllTweets(int profileID){
        return pr.getAllTweets(profileID);
    }
    /**
     * 
     * @param id
     * @param website
     * @return 
     */
    public boolean editProfileWebsite(int id, String website) {
        return pr.editProfileWebsite(id, website);
    }
    /**
     * 
     * @param profileDAO 
     */
    public void setDAO(ProfileDAO profileDAO) {
        this.pr = profileDAO;
    }
    
    
    
    
    

    
    
}
