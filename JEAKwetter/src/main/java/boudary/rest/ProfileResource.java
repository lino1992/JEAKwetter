/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Profile;
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
    @Path("GetAllProfile")
    public List<Profile> allProfile(){
        return ps.allProfile();
    }
    
    @POST
    @Path("CreateUser")
    @Consumes("application/json")
    public Profile createNewUser(Profile profile){
        return ps.createNewUser(profile);
    }  

    @POST
    @Path("EditUsername")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean editUsername(@FormParam("id")int id, @FormParam("newUsername")String newUsername){
        return ps.editUsername(id, newUsername);
    }
    @POST
    @Path("EditProfileBio")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean editProfileBio(@FormParam("id")int id, @FormParam("bio")String bio){
        return ps.editProfileBio(id, bio);
    }
    @POST
    @Path("EditProfileLocation")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean editProfileLocation(@FormParam("id")int id , @FormParam("location")String location){
       return ps.editProfileLocation(id, location);
    }
    @POST
    @Path("EditProfileWebsite")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean editProfileWebsite(@FormParam("id")int id , @FormParam("website")String website){
       return ps.editProfileWebsite(id, website);
    }
    @POST
    @Path("AddFollowing")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean addFollowing(@FormParam("id")int id, @FormParam("followingId")int followingID){
        return ps.addFollowing(id, followingID);
    }
    @GET
    @Path("GetAllFollowing/{id}")
    public List<Profile> getAllFollowing(@PathParam("id")int id){
        return ps.getAllFollowing(id);
    }
    @GET
    @Path("GetAllFollower/{id}")
    public List<Profile> getAllFollower(@PathParam("id")int id){
        return ps.getAllFollower(id);
    }
    @GET
    @Path("tweets/{id}")
    public List<Tweets> getAllTweets(@PathParam("id")int id){
        return ps.getAllTweets(id);
    }
    

}
