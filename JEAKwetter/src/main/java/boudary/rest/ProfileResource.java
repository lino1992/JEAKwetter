/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import service.ProfileService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Profile")
public class ProfileResource {
    
    @Inject
    ProfileService ps;
    
    @GET
    public List<Profile> allProfile(){
        return ps.allProfile();
    }
    
}
