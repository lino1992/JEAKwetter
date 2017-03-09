/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 *
 * @author lino_
 */
@Entity
@NamedQuery(name = "Tweets.all", query="SELECT t FROM Tweets t")
public class Tweets implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=140) 
    private String textMessage;
    private String hashTag;
    private int complain;
    private Date dateTime;
    
    private List<Profile> hearts;
    @ManyToOne
    private Profile profile;
    
    public Tweets(){  
    }
    public Tweets(String textMessage, Profile profile) {
        this.textMessage = textMessage;
        this.dateTime = new Date();
        this.profile = profile;
        this.hearts = new ArrayList<>();
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }
    
    public int getComplain() {
        return complain;
    }

    public void setComplain(int complain) {
        this.complain = complain;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    
    public int getComplaint() {
        return complain;
    }

    public void setComplaint(int complain) {
        this.complain = complain;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public Profile getTweets_ID() {
        return profile;
    }

    public void setTweets_ID(Profile profile) {
        this.profile = profile;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Profile> getHearts() {
        return hearts;
    }

    public void setHearts(List<Profile> hearts) {
        this.hearts = hearts;
    }
    
    
}
