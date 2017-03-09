/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Tweets;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import service.TweetsService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Tweets")
@DeclareRoles({"admin_user", "regular_user"})
public class TweetsResource {
    @Inject
    TweetsService ts;
    
    @POST
    @Path("DeleteTweets")
    @RolesAllowed({"admin_user"})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean deleteTweets(@FormParam("tweetsId")int tweetsId){
        return ts.deleteTweets(tweetsId);
    }
    @GET
    @Path("GetAllTweetsWithComplains")
    @RolesAllowed({"admin_user"})
    public List<Tweets> getAllTweetsWithComplains(){
        return ts.getAllTweetsWithComplains();
    }
    
    @POST
    @Path("CreateNewTweets")
    @Consumes("application/json")
     public Tweets createNewTweets(Tweets tweets) {
       return ts.createNewTweets(tweets);
    }
     
     
     
     
}
