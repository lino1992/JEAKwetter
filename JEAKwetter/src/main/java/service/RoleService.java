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
    
    public Role createNewRole(Role role) {
        return r.createNewRole(role);
    }
    public boolean addRoleToUser(Role role){
        return r.addRoleToProfile(role);
    }

    public List<Role> getAllRole() {
        return r.getAllRole();
    }
}
