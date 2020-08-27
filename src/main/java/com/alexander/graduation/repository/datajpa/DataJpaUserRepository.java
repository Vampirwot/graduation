package com.alexander.graduation.repository.datajpa;

import com.alexander.graduation.model.User;
import com.alexander.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    private CrudUserRepository repository;

    @Autowired
    public DataJpaUserRepository(CrudUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
