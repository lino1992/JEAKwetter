/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProfileDAO;
import dao.TweetsDAO;
import domain.Profile;
import domain.Tweets;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Stateless
public class TweetsService {
    
    @Inject
    TweetsDAO tweets;
    /**
     * Delete tweets with the given tweets id
     * @param tweetsId
     * @return true is succesfull
     */
    public boolean deleteTweets(int tweetsId){
        return this.tweets.deleteTweets(tweetsId);
    }
    /**
     * Get all tweets with complains
     * @return list of  tweets
     */
    public List<Tweets> getAllTweetsWithComplains(){
        return this.tweets.getAllTweetsWithComplains();
    }
    /**
     * Create new tweets 
     * @param tweets
     * @return return tweets if succesfull else null
     */
    public Tweets createNewTweets(Tweets tweets) {
        return this.tweets.createNewTweets(tweets);
    }
    /**
     * 
     * @param tweetsDAO 
     */
    public void setDAO(TweetsDAO tweetsDAO) {
        this.tweets = tweetsDAO;
    }
    /**
     * Get all tweets by the tweets hashtag
     * @param hashTag
     * @return list of  available tweets
     */
    public List<Tweets> searchTweets(String hashTag){
        return this.tweets.searchTweets(hashTag);
    }
    
    
    
}
