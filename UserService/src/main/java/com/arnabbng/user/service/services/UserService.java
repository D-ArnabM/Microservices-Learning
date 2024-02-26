package com.arnabbng.user.service.services;

import com.arnabbng.user.service.entities.User;

import java.util.List;

public interface UserService {
    //create user
    User saveUser(User user);

    //get all users
    List<User> getAllUser();

    //get single user of given userId
    User getUser(String userId);

    //TODO:delete
    //update user
    User updateUser(User user);
}
