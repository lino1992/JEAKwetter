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
    
    
    
    public List<Profile> allProfile(){
        return pr.allProfile();
    }
    
    public Profile createNewUser(Profile profile){
        return pr.createNewUser(profile);
    }
    
    public boolean editUsername(int id, String newUsername){
        return pr.editUsername(id, newUsername);
    }
    
    public boolean editProfileBio(int id, String bio){
        return pr.editProfileBio(id, bio);
    }
    
    public boolean editProfileLocation(int id , String location){
       return pr.editProfileLocation(id, location);
    }
    
    public boolean addFollowing(int id, int followingID){
        return pr.addFollowing(id, followingID);
    }
    
    public List<Profile> getAllFollowing(int profileID){
        return pr.getAllFollowing(profileID);
    }
    
    public List<Profile> getAllFollower(int profileID){
        return pr.getAllFollowing(profileID);
    }
    
    public List<Tweets> getAllTweets(int profileID){
        return pr.getAllTweets(profileID);
    }

    public boolean editProfileWebsite(int id, String website) {
        return pr.editProfileWebsite(id, website);
    }

    public void setDAO(ProfileDAO profileDAO) {
        this.pr = profileDAO;
    }
    
    
    
    
    

    
    
}
