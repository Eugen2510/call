package dev.challenge.callanalyzer.service;

import dev.challenge.callanalyzer.model.entity.Category;
import dev.challenge.callanalyzer.model.entity.Point;
import dev.challenge.callanalyzer.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointRepository pointRepository;

    public List<Point> getAllPoints(){
        return pointRepository.findAll();
    }

    public void createPoint(Category category, String key){
        Point point = new Point();
        point.setKeyPoint(key);
        point.setCategory(category);
        pointRepository.save(point);
    }

    public List<Point> getPointsByCategory(Category category){
        return pointRepository.findAllByCategory(category);
    }

}
