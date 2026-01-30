package com.SettleUp.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SettleUp.Entity.Category;
import com.SettleUp.Entity.Group;
import com.SettleUp.Entity.Users;
import com.SettleUp.Repository.CategoryRepository;
import com.SettleUp.Repository.GroupRepository;
import com.SettleUp.Repository.UserRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository,
                           GroupRepository groupRepository,
                           UserRepository userRepository){
        this.categoryRepository = categoryRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Category createCategory(Category category, Long groupId, Long userId){
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        category.setGroup(group);
        category.setCreatedBy(user);
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
