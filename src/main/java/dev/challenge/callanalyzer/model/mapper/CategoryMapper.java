package dev.challenge.callanalyzer.model.mapper;

import dev.challenge.callanalyzer.model.dto.CategoryDto;
import dev.challenge.callanalyzer.model.entity.Category;
import dev.challenge.callanalyzer.model.entity.Point;
import dev.challenge.callanalyzer.model.request.CategoryRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
public class CategoryMapper {

    public Category mapRequestToCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setTitle(categoryRequest.title());
        return category;
    }

    public CategoryDto mapCategoryToDto(Category category, List<Point> points){
        List<String> keyPoints = points.stream().map(Point::getKeyPoint).toList();
        return CategoryDto.builder()
                .id(category.getId())
                .title(category.getTitle())
                .points(keyPoints)
                .build();

    }
}
