package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }
    @GetMapping("/getUser")
    public List<User> getAllUser(){
        return service.getUser();
    }

    @GetMapping("/getUserById")
    public User getUserById(int id){
        return service.getUserById(id);
    }

}
