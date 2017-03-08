/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwetter.domain;

import com.sun.prism.impl.PrismSettings;
import domain.Profile;
import domain.Role;
import domain.Tweets;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lino_
 */

public class DomainTest {
    
    
    Profile profile;
    Profile profile1;
    
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
    public void Test_Profile(){
        profile = new Profile("lino", "username1", "p@33word");
        profile1 = new Profile("lino", "username1", "p@33word");
        //Object is not the same
        Assert.assertNotEquals("Object is not the same", profile, profile1);
        //Object has the same name
        Assert.assertTrue(profile.getName().equalsIgnoreCase(profile1.getName()));
        
        
        
    }
}
