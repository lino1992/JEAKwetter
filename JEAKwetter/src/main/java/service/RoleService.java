/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RoleDAO;
import domain.Profile;
import domain.Role;
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
    
    public void createNewRole(Role role) {
        r.createNewRole(role);
    }
    public void addRoleToUser(Role role){
        r.addRoleToProfile(role);
    }
}
