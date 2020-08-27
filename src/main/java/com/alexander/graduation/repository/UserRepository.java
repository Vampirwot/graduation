package com.alexander.graduation.repository;

import com.alexander.graduation.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
    User getById(Long id);
    void save(User user);
}
