/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Profile;
import domain.Role;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import service.RoleService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Role")
@DeclareRoles({"admin_user", "regular_user"})
public class RoleResource {
    @Inject
    RoleService rs;
    
    @POST
    @Path("CreateNewRole")
    @RolesAllowed({"admin_user"})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Role createNewRole(@FormParam("role")String role) {
        return rs.createNewRole(new Role(role));
    }
    
    @GET
    @Path("GetAllRole")
    @RolesAllowed({"admin_user"})
    public List<Role> getAllRole(){
        return rs.getAllRole();
    }
    
    @POST
    @Path("AddRoleToUser")
    @RolesAllowed({"admin_user"})
    @Consumes("application/json")
    public boolean addRoleToUser(Role role){
        return rs.addRoleToUser(role);
    }
    
}
