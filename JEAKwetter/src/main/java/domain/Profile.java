/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author lino_
 */
@Entity
@NamedQuery(name = "Profile.all", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length=40) 
    private String bio;
    private String location;
    private String website;
    private List<Profile> Followers;
    private List<Profile> Following;

    public List<Tweets> getTweet() {
        return tweet;
    }

    public void setTweet(List<Tweets> tweet) {
        this.tweet = tweet;
    }
    
    private List<Tweets> tweet;
    
    public Profile(){
        
    }
    
    public Profile(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Profile> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<Profile> Followers) {
        this.Followers = Followers;
    }

    public List<Profile> getFollowing() {
        return Following;
    }

    public void setFollowing(List<Profile> Following) {
        this.Following = Following;
    }
    
    
    
    
    
    
}
