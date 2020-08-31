package com.alexander.graduation.repository;

import com.alexander.graduation.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> getAllByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update Vote v set v.date = ?1, v.restaurantId = ?2 where v.id = ?3")
    void update(LocalDate date, Long restId, Long id);

    Vote getByDateAndUserId(LocalDate date, Long userId);

    List<Vote> getAllByDate(LocalDate date);
}
