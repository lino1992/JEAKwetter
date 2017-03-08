/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Profile;
import domain.Role;
import domain.Tweets;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import  javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import service.ProfileService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Profile")
public class ProfileResource {
    
    @Inject
    ProfileService ps;
    
    @GET
    @Path("/GetAllProfile")
    public List<Profile> allProfile(){
        return ps.allProfile();
    }
    
    @POST
    @Path("/CreateUser")
    public void createNewUser(String p){
        ps.createNewUser(p);
    }  
    @POST
    @Path("/EditUsername")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean editUsername(@FormParam("id")int id, @FormParam("newUsername")String newUsername){
        return ps.editUsername(id, newUsername);
    }
    @POST
    @Path("/EditProfileBio")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean editProfileBio(@FormParam("id")int id, @FormParam("bio")String bio){
        return ps.editProfileBio(id, bio);
    }
    @POST
    @Path("/EditProfileLocation")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean editProfileLocation(@FormParam("id")int id , @FormParam("location")String location){
       return ps.editProfileLocation(id, location);
    }
    @POST
    @Path("/AddFollowing")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean addFollowing(@FormParam("id")int id, @FormParam("profile")Profile profile){
        return ps.addFollowing(id, profile);
    }
    @GET
    @Path("{id}/GetAllFollowing")
    public List<Profile> getAllFollowing(@PathParam("id")int profileID){
        return ps.getAllFollowing(profileID);
    }
    @GET
    @Path("{id}/GetAllFollower")
    public List<Profile> getAllFollower(@PathParam("id")int profileID){
        return ps.getAllFollowing(profileID);
    }
    @GET
    @Path("/{id}/tweets")
    public List<Tweets> getAllTweets(@PathParam("id")int profileID){
        return ps.getAllTweets(profileID);
    }

}
