package com.SettleUp.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SettleUp.Entity.Group;
import com.SettleUp.Service.GroupService;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @PostMapping("/{createdById}")
    public ResponseEntity<Group> createGroup(@RequestBody Group group, @PathVariable Long createdById){
        return ResponseEntity.ok(groupService.createGroup(group, createdById));
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups(){
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id){
        return ResponseEntity.ok(groupService.getGroupById(id));
    }
}
