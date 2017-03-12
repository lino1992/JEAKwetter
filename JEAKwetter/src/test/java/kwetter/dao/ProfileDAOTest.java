/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwetter.dao;

import dao.ProfileDAO;
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

/**
 *
 * @author lino_
 */

public class ProfileDAOTest {
    
    Properties prop = new Properties();
    
    EntityManagerFactory emf;
    private EntityManager em;
    
    Profile profile;
    Profile profile1;
    Profile profile2;
    Profile profile3;
    List<Role> role;
    List<Profile> following;
    List<Tweets> tweets;
    

    ProfileDAO profileDAO;
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
//        profile = profile = new Profile("user1", "username1", "p@33word1");
//        profile1 = profile = new Profile("user2","username2", "p@33word2");
//        profile2 = profile = new Profile("user3", "username3", "p@33word3");
//        profile3 = profile = new Profile("user4", "username4", "p@33word4");    
//        em = emf.createEntityManager();
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
//        profileDAO = new ProfileDAO(em);
//        profileDAO.createNewUser(profile);
//        profileDAO.createNewUser(profile1);
//        profileDAO.createNewUser(profile2);
//        profileDAO.createNewUser(profile3);
//        
//        assertNotNull(profileDAO);
//        List<Profile> users = profileDAO.allProfile();
//        assertNotNull(users);
//        assertEquals(4, users.size());
    }
}
