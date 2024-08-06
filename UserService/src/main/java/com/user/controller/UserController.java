package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 =userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user1 = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user1 = userService.getAllUser();
        return ResponseEntity.ok(user1);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@PathVariable String userId,@RequestBody User user){
        User user1 = userService.udateUser(userId,user);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }
//    @DeleteMapping("/{userId}")
//    public String deleteUser(@PathVariable String userId){
//        boolean delete = userService.removeUser(userId);
//        if (delete){
//            return "User "+userId+" delete successfully";
//        }
//        else
//            return "User "+userId+" is Not Found";
//    }
}
