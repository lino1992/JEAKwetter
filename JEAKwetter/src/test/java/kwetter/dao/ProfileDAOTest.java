/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwetter.dao;

import dao.ProfileDAO;
import dao.RoleDAO;
import dao.TweetsDAO;
import domain.Profile;
import domain.Role;
import domain.Tweets;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DatabaseCleaner;

/**
 *
 * @author lino_
 */

public class ProfileDAOTest {
    
    Properties prop = new Properties();
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestResource");
    private EntityManager em;
    private EntityTransaction tx;
    
    Profile profile;
    Profile profile1;
    Profile profile2;
    Profile profile3;
    List<Role> role;
    List<Profile> following;
    Tweets tweets;
    

    ProfileDAO profileDAO;
    RoleDAO roleDAO;
    TweetsDAO tweetsDAO;
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        profile  = new Profile("user1", "username1", "p@33word1");
        profile1  = new Profile("user2","username2", "p@33word2");
        profile2  = new Profile("user3", "username3", "p@33word3");
        profile3  = new Profile("user4", "username4", "p@33word4"); 
//        try {
//            new DatabaseCleaner(emf.createEntityManager()).clean();
//        }catch(SQLException ex){
//            Logger.getLogger(ProfileDAOTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        em = emf.createEntityManager();
        tx = em.getTransaction();
        profileDAO = new ProfileDAO();
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
    public void Test_Profile_DAO(){
        profileDAO = new ProfileDAO(em);
        tweetsDAO = new TweetsDAO(em);
        tx.begin();
        profile = profileDAO.createNewUser(profile);
        profile1 = profileDAO.createNewUser(profile1);
        profile2 = profileDAO.createNewUser(profile2);
        profile3 =profileDAO.createNewUser(profile3);
        tx.commit();
        
        assertNotNull(profileDAO);
        List<Profile> users = profileDAO.allProfile();
        assertNotNull(users);
        assertEquals(4, users.size());
        
        
        tx.begin();
        profileDAO.addFollowing(1, 4);
        profileDAO.getAllFollower(1);
        tx.commit();
        
        Profile profileWithFriends = profileDAO.getProfileById(1);
        assertTrue(profileWithFriends.getFollower().size() == 1);
        
        tweets = new Tweets("Test tekst", profileWithFriends);
        tx.begin();
        tweets = tweetsDAO.createNewTweets(tweets);
        tx.commit();
        
        assertTrue(tweets.getProfile().getId() == 1);
        assertTrue(tweets.getTekst() == "Test tekst");
        
    }
}
