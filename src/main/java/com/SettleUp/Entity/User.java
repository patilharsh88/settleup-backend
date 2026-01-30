package com.SettleUp.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // USER / ADMIN

    @Column(nullable = false)
    private boolean active = true;

    @ManyToMany(mappedBy = "members")
    private Set<Group> groups = new HashSet<>();

    public String getName() { 
    	return name; 
    	}
    public void setName(String name) { 
    	this.name = name;
    	}

    public String getEmail() { 
    	return email; 
    	}
    public void setEmail(String email) { 
    	this.email = email; 
    	}

    public String getPassword() {
    	return password;
    	}
    public void setPassword(String password) {
    	this.password = password;
    	}

    public String getRole() {
    	return role;
    	}
    public void setRole(String role) {
    	this.role = role;
    	}

    public boolean isActive() { 
    	return active; 
    	}
    public void setActive(boolean active) { 
    	this.active = active;
    	}

    public Set<Group> getGroups() { 
    	return groups;
    	}
    public void setGroups(Set<Group> groups) {
    	this.groups = groups;
    	}
    
}
