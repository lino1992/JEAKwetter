/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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
    @Column(length=140) 
    private String bio;
    private String location;
    private String website;
    @Column(unique = true)
    private String username;
    @Column (length = 500)
    private String password;
    private Blob picture;
    

    
    
    @ManyToMany(mappedBy = "profile_role")
    private List<Role> role;
    
    @OneToMany(mappedBy = "profile")
    private List<Tweets> tweets;
    
    
    @ManyToMany
    private List<Profile> following;
    
    @ManyToMany(mappedBy = "following")
    private List<Profile> owner;
    
    public Profile(){
    
    }
    
    public Profile(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.following = new ArrayList<>();
        this.role = new ArrayList<>();
        this.owner = new ArrayList<>();
        this.tweets = new ArrayList<>();
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public List<Profile> getOwner() {
        return owner;
    }

    public void setOwner(List<Profile> owner) {
        this.owner = owner;
    }

    public List<Tweets> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweets> tweets) {
        this.tweets = tweets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Profile> getFollowing() {
        return following;
    }

    public void setFollowing(List<Profile> following) {
        this.following = following;
    }
    
    public boolean addFollowing(Profile profile){
        if(!this.following.contains(profile)){
            this.following.add(profile);
            return true;
        }
        return false;
    }
    public void addTweets(Tweets tweets){
        this.tweets.add(tweets);
    }
    
    
    
    
}
