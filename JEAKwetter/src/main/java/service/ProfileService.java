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
     * Get all profile 
     * @return all profile from select query in dao
     */
    public List<Profile> allProfile(){
        return pr.allProfile();
    }
    /**
     * create new user
     * @param profile
     * @return profile after create is succesfull
     */
    public Profile createNewUser(Profile profile){
        return pr.createNewUser(profile);
    }
    /**
     * Edit username of a profile with the given id of the profile
     * @param id
     * @param newUsername
     * @return true if succesfull else false
     */
    public boolean editUsername(int id, String newUsername){
        return pr.editUsername(id, newUsername);
    }
    /**
     * Edit bio of a profile with the given id of the profile
     * @param id
     * @param bio
     * @return true  if succesfull else false
     */
    public boolean editProfileBio(int id, String bio){
        return pr.editProfileBio(id, bio);
    }
    /**
     * Edit Location of a profile with the given id of the profile
     * @param id
     * @param location
     * @return true  if succesfull else false
     */
    public boolean editProfileLocation(int id , String location){
       return pr.editProfileLocation(id, location);
    }
    /**
     * Add new profile to the list that profile would like to follow
     * @param id
     * @param followingID
     * @return true if persist is succesfull
     */
    public boolean addFollowing(int id, int followingID){
        return pr.addFollowing(id, followingID);
    }
    /**
     * Get all profile that a profile of the given id is following
     * @param profileID
     * @return list of all profile
     */
    public List<Profile> getAllFollowing(int profileID){
        return pr.getAllFollowing(profileID);
    }
    /**
     * Get all profile that is following a profile
     * @param profileID
     * @return list of profile
     */
    public List<Profile> getAllFollower(int profileID){
        return pr.getAllFollower(profileID);
    }
    /**
     * Get all tweets of a profile with the given profile id
     * @param profileID
     * @return list of tweets
     */
    public List<Tweets> getAllTweets(int profileID){
        return pr.getAllTweets(profileID);
    }
    /**
     * Edit website of a profile with the given id of the profile
     * @param id
     * @param website
     * @return true  if succesfull else false
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

    public Profile getProfileByUsername(String name) {
        return this.pr.getProfileByName(name);
    }
    
    
    
    
    

    
    
}
