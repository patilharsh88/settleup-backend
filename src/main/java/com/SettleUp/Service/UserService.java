package com.SettleUp.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SettleUp.Entity.Users;
import com.SettleUp.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Users createUser(Users user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    public Optional<Users> getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Users updateUser(Long id, Users updatedUser){
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setActive(updatedUser.isActive());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id){
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(existingUser);
    }
}
