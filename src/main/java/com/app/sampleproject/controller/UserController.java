package com.app.sampleproject.controller;

import com.app.sampleproject.entity.Product;
import com.app.sampleproject.entity.User;
import com.app.sampleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sample")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/alluser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
