package com.example.backend.user.service;

import com.example.backend.user.model.User;

import java.util.Collection;

public interface UserService {
    User create(User user);
    Collection<User> list(int limit);
    User get(Long id);
    User get(String email);
    User update(User user);
    Boolean verifyLogin(String email,String password);
    Boolean delete(Long id);

}
