/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.ProfileDAO;
import domain.Profile;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Singleton
public class Init {
    
    @Inject
    ProfileDAO pr;
    
    @PostConstruct
    public void init(){
        Profile profile = new Profile("Lino Thaencharun");
        pr.save(profile);
    }
}
