/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwetter.service;

import dao.ProfileDAO;
import dao.RoleDAO;
import dao.TweetsDAO;
import domain.Profile;
import domain.Role;
import domain.Tweets;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import service.ProfileService;
import service.RoleService;
import service.TweetsService;

/**
 *
 * @author lino_
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceTest {
    
    RoleService rlService;
    TweetsService tsService;
    ProfileService psservice;
    @Mock
    ProfileDAO profileDAO;
    
    @Mock
    RoleDAO roleDAO;
    
    @Mock
    TweetsDAO tweetsDAO;
    
    Profile profile;
    Role role;
    Tweets tweets;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        psservice = new ProfileService();
        psservice.setDAO(profileDAO);
        
        rlService = new RoleService();
        rlService.setDAO(roleDAO);
        
        tsService = new TweetsService();
        tsService.setDAO(tweetsDAO);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void Test_SaveUser(){
       profile = new Profile( "user1", "username1", "p@33word1");
       psservice.createNewUser(profile);
       
       verify(profileDAO, Mockito.times(1)).createNewUser(profile);
    }
    
    @Test
    public void Test_SaveRole(){
       role = new Role("Test");
       rlService.createNewRole(role);
       
        verify(roleDAO, Mockito.times(1)).createNewRole(role);
    }
    
    @Test
    public void Test_SaveTweets(){
        profile = new Profile( "user1", "username1", "p@33word1");
       tweets = new Tweets("Test tweets", profile);
       tsService.createNewTweets(tweets);
       
        verify(tweetsDAO, Mockito.times(1)).createNewTweets(tweets);
    }
    
    
}
