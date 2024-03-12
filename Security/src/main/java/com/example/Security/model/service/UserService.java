package com.example.Security.model.service;

import com.example.Security.model.enitity.Users;


public interface UserService {
    Users findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    Users saveOrUpdate(Users users);
}