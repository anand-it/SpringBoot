package com.app.sampleproject.impl;

import com.app.sampleproject.entity.Product;
import com.app.sampleproject.entity.User;
import com.app.sampleproject.repository.UserRepository;
import com.app.sampleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userrepository;

    @Override
    public List<User> getAllUser() {
        return userrepository.findAll();
    }
}
