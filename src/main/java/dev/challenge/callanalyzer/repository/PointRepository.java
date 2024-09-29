package dev.challenge.callanalyzer.repository;

import dev.challenge.callanalyzer.model.entity.Category;
import dev.challenge.callanalyzer.model.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point> findAllByCategory(Category category);
}
