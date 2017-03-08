/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwetter.service;

import dao.ProfileDAO;
import domain.Profile;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.is;
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
public class ServiceTest {
    
    @Inject
    ProfileDAO profileDAO;
    
    Profile profile;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
//        profile = profile = new Profile( "user1", "bio test1","eindhoven", "www.test1.com", "username1", "p@33word1");
//       Profile profileResult =  profileDAO.createNewUser(profile);
//       
//       assertThat(profileResult, is(profile));
//       verify(_entityManager).persist(profile);
    }
}
