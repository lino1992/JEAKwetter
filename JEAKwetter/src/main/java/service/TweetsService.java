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
    
    public boolean deleteTweets(int tweetsId){
        return this.tweets.deleteTweets(tweetsId);
    }
    
    public List<Tweets> getAllTweetsWithComplains(){
        return this.tweets.getAllTweetsWithComplains();
    }
    
    public Tweets createNewTweets(Tweets tweets) {
        return this.tweets.createNewTweets(tweets);
    }

    public void setDAO(TweetsDAO tweetsDAO) {
        this.tweets = tweetsDAO;
    }
    
    
    
}
