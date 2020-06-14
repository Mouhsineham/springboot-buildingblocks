package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User>  getAllUsers(){
        return  userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return  userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public  User  updateUserById(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/users/{id}")
    public  void  deleteUserById(@PathVariable("id") Long id){
      userService.deleteUserById(id);
    }

    @GetMapping("/users/byusername/{username}")
    public  User  getUserByUserName(@PathVariable("username") String username){
        return userService.getUserByUserName(username);
    }




}
