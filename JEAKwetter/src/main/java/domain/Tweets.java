/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author lino_
 */
@Entity
@NamedQueries ({
    @NamedQuery(name = "Tweets.all", query="SELECT t FROM Tweets t"),
    @NamedQuery(name = "Tweets.byUserId", query="SELECT T FROM Tweets t where t.profile.id = :id"),
    @NamedQuery(name = "Tweets.allTweetsFollowing", query="SELECT T FROM Tweets t JOIN t.profile p  JOIN p.follower f where p.id = :id and f.id = t.profile.id")
})

public class Tweets implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=140) 
    private String tekst;
    private String subject;
    private int complain;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date timeCreated;
    @ManyToOne
    private Profile profile;
    
    public Tweets(){  
    }
    public Tweets(String tekst, Profile profile) {
        this.tekst = tekst;
        this.profile = profile;
        this.timeCreated = new Date();
    }

    public Tweets(String message, String subject, Profile profile) {
        this.tekst = message;
        this.subject = subject;
        this.profile = profile;
        this.timeCreated = new Date();
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getComplain() {
        return complain;
    }

    public void setComplain(int complain) {
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

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    
    
}
