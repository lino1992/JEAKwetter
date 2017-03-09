/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author lino_
 */
@Entity
@NamedQuery(name = "Role.all", query="SELECT r FROM Role r")
public class Role implements Serializable {
    @Id
    private String groupName;
    
    @ManyToMany
    @JoinTable(name="USER_GROUP",
    joinColumns = @JoinColumn(name = "groupName",
    referencedColumnName = "groupName"),
    inverseJoinColumns = @JoinColumn(name = "username",
    referencedColumnName = "username"))
    private List<Profile> profile_role;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public List<Profile> getProfile_role() {
        return profile_role;
    }

    public void setProfile_role(List<Profile> profile_role) {
        this.profile_role = profile_role;
    }
    

    public Role(String right) {
        this.groupName = right;
        this.profile_role = new ArrayList<>();
    }
    public Role() {
    }
    
    
}
