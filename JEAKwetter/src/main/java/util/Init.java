/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.ProfileDAO;
import dao.RoleDAO;
import domain.Profile;
import domain.Role;
import java.util.ArrayList;
import java.util.List;
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
    
    @PostConstruct
    public void init(){
        Profile profile = new Profile("Lino Thaencharun","lino_t","LAvulveNgox3PY0FRAc+HbMvNY0of1NOuOc6r9r+mmA=");
        Profile profile1= new Profile("Ruthger van den Eikhof", "ruthger_vde","r");   

        pr.createNewUser(profile);
        pr.createNewUser(profile1);
        Role role = new Role("Regular");
        ro.createNewRole(role);
        
        List<Profile> profileList = new ArrayList<>();
        profileList.add(profile);
        role.setProfile_role(profileList);
        
        ro.addRoleToProfile(role);
        
        pr.addFollowing(1, 2);
        
       
    }
}
