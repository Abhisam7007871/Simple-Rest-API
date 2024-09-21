package com.avhsek.simple_rest_api.controller;

import com.avhsek.simple_rest_api.model.User;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    //  create a new user
    @PostMapping
    public User createUser(@RequestBody User user){
        users.add(user);
        return user;
    }

    // get all users
    @GetMapping
    public List<User> getAllUser(){
        return users;
    }




}
