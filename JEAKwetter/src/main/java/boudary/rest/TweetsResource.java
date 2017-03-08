/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Tweets;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.TweetsService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Tweets")
public class TweetsResource {
    @Inject
    TweetsService ts;
    
    @POST
    @Path("/CreateNewTweets")
     public void createNewTweets(Tweets tweets) {
        ts.createNewTweets(tweets);
    }
    @POST
    @Path("/DeleteTweets")
    public boolean deleteTweets(int tweetsId){
        return ts.deleteTweets(tweetsId);
    }
    @GET
    @Path("/GetAllTweetsWithComplains")
    public List<Tweets> getAllTweetsWithComplains(){
        return ts.getAllTweetsWithComplains();
    }
}
