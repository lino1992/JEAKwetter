/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RoleDAO;
import domain.Profile;
import domain.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Stateless
public class RoleService {
    @Inject
    RoleDAO r;
    /**
     * create a new role 
     * @param role
     * @return role if role is created else null
     */
    public Role createNewRole(Role role) {
        return r.createNewRole(role);
    }
    /**
     * add a profile to a role
     * @param role
     * @return true is it is succesfull
     */
    public boolean addRoleToUser(Role role){
        return r.addRoleToProfile(role);
    }
    /**
     * Get all role is database
     * @return list of all role
     */
    public List<Role> getAllRole() {
        return r.getAllRole();
    }
    /**
     * 
     * @param roleDAO 
     */
    public void setDAO(RoleDAO roleDAO) {
        this.r = roleDAO;
    }
}
