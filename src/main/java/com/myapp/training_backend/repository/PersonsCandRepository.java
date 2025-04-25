package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.PersonsCand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonsCandRepository extends JpaRepository<PersonsCand, Integer> {

    @Query(value = "SELECT * FROM persons_cand p WHERE p.d_in = :today", nativeQuery = true)
    List<PersonsCand> findByDateInToday(@Param("today") LocalDate today);
}
