package com.SettleUp.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SettleUp.Entity.Group;
import com.SettleUp.Entity.Users;
import com.SettleUp.Repository.GroupRepository;
import com.SettleUp.Repository.UserRepository;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository){
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group createGroup(Group group, Long createdById){
        Users creator = userRepository.findById(createdById)
                .orElseThrow(() -> new RuntimeException("User not found"));
        group.setCreatedBy(creator);
        group.getMembers().add(creator); // creator is automatically a member
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public Group getGroupById(Long id){
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }
}
