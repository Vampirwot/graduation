package com.alexander.graduation.repository;

import com.alexander.graduation.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant,Long> {
}
