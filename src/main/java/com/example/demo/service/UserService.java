package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.sun.xml.bind.v2.model.core.ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import javax.persistence.Id;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // Save
    public User saveUser(User user){
        return repository.save(user);
    }

    // GetAll
    public List<User> getUser(){
        return repository.findAll();
    }

    // Get ById
    public User getUserById(int userid){
        return repository.findById(userid).orElse(null);
    }

//    Get ByName
//    public User getUserByName(@PathVariable String firstname) {
//        return repository.findByName(firstname);
//    }

    // Update
    public String updateUser(User user) {
        User existingUser = repository.findById(user.getUserid()).orElse(null);
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhonenumber(user.getPhonenumber());
        existingUser.setDob(user.getDob());
       repository.save(existingUser);
        return "Updated";
    }

    // delete
    public String deleteUser(int id){
        repository.deleteById(id);
        return "Deleted";
    }
}
