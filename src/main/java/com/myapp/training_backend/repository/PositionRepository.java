package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    List<Position> findAllByNameIgnoreCase(String currentPosition);
//    Optional<List<HandbookPosition>> findAllByNameIgnoreCase(String currentPosition);

//    @Query(value = "SELECT p FROM handbook_position p WHERE p.appoint_name = :name ORDER BY p.appoint_id ASC", nativeQuery = true)
//    List<HandbookPosition> findMultipleByName(@Param("name") String name);
//
//    default Optional<HandbookPosition> findFirstByName(String name) {
//        List<HandbookPosition> positions = findMultipleByName(name);
//        return positions.stream().findFirst();
//    }
}
