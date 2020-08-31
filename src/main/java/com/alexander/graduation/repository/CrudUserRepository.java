package com.alexander.graduation.repository;

import com.alexander.graduation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User,Long> {

    @Override
    List<User> findAll();
}
