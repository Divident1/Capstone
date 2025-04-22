package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.model.UserDTO;

public interface UserService {
    UserDTO getUserByEmail(String email);
    User saveUser(User user);
}