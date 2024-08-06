package com.user.service;

import com.user.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(String userId);
    List<User> getAllUser();
    User udateUser(String userId,User user);
//    boolean removeUser(String userId);

}
