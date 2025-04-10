package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.TrainingField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainingFieldRepository extends JpaRepository<TrainingField, Integer> {
//    Optional<TrainingField> findByCourse(String courseStr);

//    @Query(value = "SELECT c FROM training_field c WHERE c.training_field = :title ORDER BY c.id ASC", nativeQuery = true)
//    List<TrainingField> findMultipleByTitle(@Param("title") String title);
//
//    default Optional<TrainingField> findFirstByTitle(String title) {
//        List<TrainingField> courses = findMultipleByTitle(title);
//        return courses.stream().findFirst();
//    }

    List<TrainingField> findAllByCourse(String courseStr);
}
