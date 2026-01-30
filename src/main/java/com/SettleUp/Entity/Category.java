package com.SettleUp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Users createdBy;

    // Getters & Setters
    public String getName() { 
    	return name;
    	}
    public void setName(String name) {
    	this.name = name;
    }

    public Group getGroup() { 
    	return group; 
    	}
    public void setGroup(Group group) { 
    	this.group = group; 
    	}

    public Users getCreatedBy() { 
    	return createdBy; 
    	}
    public void setCreatedBy(Users createdBy) { 
    	this.createdBy = createdBy;
    	}
}
