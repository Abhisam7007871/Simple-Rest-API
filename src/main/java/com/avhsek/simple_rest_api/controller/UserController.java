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

    // get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(null);
    }

    // update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        for(User user : users){
            if(user.getId().equals(id)){
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                return user;
            }
        }
        return null;
    }

    // delete user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
//        users.removeIf(user -> user.getId().equals(id));
//        return "User Deleted" users.u;

        User userToDelete = users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(null);

        if(userToDelete != null){
            users.removeIf(user -> user.getId().equals(id));
            return "User " + userToDelete.getName() + " has been deleted";
        }else{
            return "User not found";
        }
    }

}
