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
public class ProfileController implements Serializable {
    
    @Inject
    ProfileService profileService;
    
    @Inject
    TweetsService tweetsService;
    
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext externalContext = fc.getExternalContext();
    
    private Long profileId;
    private Profile profile;
    private List<Profile> following;
    private List<Profile> follower;
    
    private List<Tweets> tweets;
    
    private String name = "unknown";
    private String bio = "unknown";
    private String website = "unknown";
    
    public ProfileController(){
        following = new ArrayList<>();
        follower = new ArrayList<>();
        tweets = new ArrayList<>();
        
        
    }
    
    @PostConstruct
    public void init(){
        profile = profile = profileService.getProfileByUsername(externalContext.getUserPrincipal().getName());
        tweets = tweetsService.getTweetsByProfileId(profile.getId());
        if(profile != null){
            name = profile.getName();
            bio = profile.getBio();
            website = profile.getWebsite();
        }
        follower = profileService.getAllFollower(profile.getId().intValue());
        following = profileService.getAllFollowing(profile.getId().intValue());
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    public Profile getProfile() {
        
        return profile;
    }
    
    public String navigateToHome(){
        return "index.xhtml";
    }

    public List<Profile> getFollowing() {
        return following;
    }

    public void setFollowing(List<Profile> following) {
        this.following = following;
    }

    public List<Profile> getFollower() {
        return follower;
    }

    public void setFollower(List<Profile> follower) {
        this.follower = follower;
    }

    public List<Tweets> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweets> tweets) {
        this.tweets = tweets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
    
    
    
    
    
    
    
    
    
    
}
