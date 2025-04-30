package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {

    List<Position> findAllByNameIgnoreCase(String currentPosition);

}
