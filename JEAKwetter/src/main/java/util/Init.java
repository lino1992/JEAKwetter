/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.ProfileDAO;
import dao.RoleDAO;
import dao.TweetsDAO;
import domain.Profile;
import domain.Role;
import domain.Tweets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Singleton
@Startup
@PermitAll
public class Init {
    
    @Inject
    ProfileDAO pr;
    
    @Inject
    RoleDAO ro;
    
    @Inject
    TweetsDAO tw;
    
    @PostConstruct
    public void init() {
        Profile profile = new Profile("Lino Thaencharun","lino_t",Hash.stringToHash("Lino"));
        Profile profile1= new Profile("Ruthger van den Eikhof", "ruthger_vde",Hash.stringToHash("Ruthger"));   

        profile = pr.createNewUser(profile);
        profile1 = pr.createNewUser(profile1);
        Role role = new Role("Regular");
        Role role1 = new Role("Admin");
        ro.createNewRole(role);
        
        List<Profile> profileList = new ArrayList<>();
        profileList.add(profile);
        role.setProfile_role(profileList);
        
        List<Profile> profileList1 = new ArrayList<>();
        profileList1.add(profile1);
        role1.setProfile_role(profileList1);
        
        ro.addRoleToProfile(role);
        ro.addRoleToProfile(role1);
        
        
        tw.createNewTweets(new Tweets("Test tweets", profile1));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        }
        tw.createNewTweets(new Tweets("Test tweets 2", profile));
        tw.createNewTweets(new Tweets("Test tweets 2", profile));
        tw.createNewTweets(new Tweets("Test tweets 2", profile));
        tw.createNewTweets(new Tweets("Test tweets 2", profile));
        tw.createNewTweets(new Tweets("Test tweets 2", profile));
        tw.createNewTweets(new Tweets("Test tweets 2", profile));
        tw.createNewTweets(new Tweets("Test tweets 2", profile));
        
        pr.addFollowing(1, 2);
 
        
       
    }
}
