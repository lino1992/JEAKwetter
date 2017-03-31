/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Profile;
import domain.Tweets;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import service.ProfileService;
import service.TweetsService;

/**
 *
 * @author lino_
 */
@Named
@SessionScoped
public class HomeController implements Serializable {
    
    @Inject
    private TweetsService tweetsService;
    
    @Inject
    private ProfileService profileService;
    
    private Profile profile;
    
    private List<String> language;
    
    private List<Tweets> tweets;
    
    private List<Tweets> timeLineTweets;
    
    private List<Profile> follower;
    
    private List<Profile> following;

    private String title = "HomePage";
    private String loginStatus = "Login";
    
    private String message = "Type in message";
    private String subject = "";
    
    private String lastedTime = "No time";
    private String lastedTweets = "No tweets";
    private String lastedTweetsSubject = "No subject";

    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext externalContext = fc.getExternalContext();

    public HomeController(){
        language = new ArrayList<>();
        tweets = new ArrayList<>();
        timeLineTweets = new ArrayList<>();
        follower = new ArrayList<>();
        following = new ArrayList<>();
        language.add("Netherlands");
        language.add("English");
    }
    
    @PostConstruct
    public void init(){
        if(externalContext.getUserPrincipal().getName() != null){
            profile = profileService.getProfileByUsername(externalContext.getUserPrincipal().getName());
            loginStatus = "Logout";
            tweets = tweetsService.getTweetsByProfileId(profile.getId());
            if(!tweets.isEmpty()){
                lastedTime = tweets.get(tweets.size() - 1).getTimeCreated().toString();
                lastedTweets = tweets.get(tweets.size() - 1).getTekst();
                lastedTweetsSubject = tweets.get(tweets.size() - 1).getSubject();
                timeLineTweets = tweets;
                
            }
            tweets.addAll(tweetsService.getAllFollowingTweets(profile.getId().intValue()));
            Collections.sort(tweets, new Comparator<Tweets>(){
                @Override
                public int compare(Tweets tw1, Tweets tw2){
                    return tw1.getTimeCreated().compareTo(tw2.getTimeCreated());
                }
            });
            follower = profileService.getAllFollower(profile.getId().intValue());
            following = profileService.getAllFollowing(profile.getId().intValue());
        } 
    }

    public List<Tweets> getTimeLineTweets() {
        return timeLineTweets;
    }

    public void setTimeLineTweets(List<Tweets> timeLineTweets) {
        this.timeLineTweets = timeLineTweets;
    }

    public String getLastedTweetsSubject() {
        return lastedTweetsSubject;
    }

    public void setLastedTweetsSubject(String lastedTweetsSubject) {
        this.lastedTweetsSubject = lastedTweetsSubject;
    }
    
    public List<Profile> getFollower() {
        return follower;
    }

    public void setFollower(List<Profile> follower) {
        this.follower = follower;
    }

    public List<Profile> getFollowing() {
        return following;
    }

    public void setFollowing(List<Profile> following) {
        this.following = following;
    }
    
    
    public String getLastedTweets() {
        return lastedTweets;
    }

    public void setLastedTweets(String lastedTweets) {
        this.lastedTweets = lastedTweets;
    }
    public String getLastedTime() {
        return lastedTime;
    }

    public void setLastedTime(String lastedTime) {
        this.lastedTime = lastedTime;
    }
    
    
    public List<String> getLanguage() {
        return language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tweets> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweets> tweets) {
        this.tweets = tweets;
    }
    
    public String getLoginStatus() {
        
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
    
    public void createNewTweets(){
        Tweets resultTweets = null;
        if(!message.isEmpty() && profile != null){
            if(message.contains("#")){
                String[] messageWithHashTag = message.split("#");
                 resultTweets = tweetsService.createNewTweets(new Tweets(messageWithHashTag[0], "#" + messageWithHashTag[1], profile));
                tweets.add(resultTweets);
                message = "";
                lastedTime = tweets.get(tweets.size() - 1).getTimeCreated().toString();
                lastedTweets = tweets.get(tweets.size() - 1).getTekst();
                lastedTweetsSubject = tweets.get(tweets.size() - 1).getSubject();
            }else{
                resultTweets = tweetsService.createNewTweets(new Tweets(message, profile));
                tweets.add(resultTweets);
                message = "";
                lastedTime = tweets.get(tweets.size() - 1).getTimeCreated().toString();
                lastedTweets = tweets.get(tweets.size() - 1).getTekst();
                lastedTweetsSubject = tweets.get(tweets.size() - 1).getSubject();
            }
            if(timeLineTweets.isEmpty()){
                timeLineTweets.add(resultTweets);
            }else{
                timeLineTweets.add(0, resultTweets);
            }
            
        }
        System.out.println(message);
        
    }
    
    public String navigateToProfile(){
        return "profile.xhtml"  ;
    }
    
    
    

}
