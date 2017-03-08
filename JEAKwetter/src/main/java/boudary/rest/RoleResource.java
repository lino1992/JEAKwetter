/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Role;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.RoleService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Role")
public class RoleResource {
    @Inject
    RoleService rs;
    
    @POST
    @Path("/CreateNewRole")
    public void createNewRole(Role role) {
        rs.createNewRole(role);
    }
}
