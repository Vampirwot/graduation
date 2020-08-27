package com.alexander.graduation.web.controller;

import com.alexander.graduation.model.Role;
import com.alexander.graduation.model.User;
import com.alexander.graduation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/test")
public class Test {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository repository;

    @Autowired
    public Test(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public User hello(@PathVariable Long id) {
        return repository.getById(id);
    }

    @GetMapping("/")
    public List<User> getAll() {
        return repository.getAll();
    }

    @GetMapping("/create")
    public void create(@RequestParam(value = "id", required = false) Long id,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "email", required = false) String email,
                       @RequestParam(value = "password",required = false) String pass) {
        User user = new User(id,name,email,pass);
        repository.save(user);
    }
}
