package com.alexander.graduation.repository.datajpa;

import com.alexander.graduation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudUserRepository extends JpaRepository<User,Long> {

    @Override
    List<User> findAll();
}
