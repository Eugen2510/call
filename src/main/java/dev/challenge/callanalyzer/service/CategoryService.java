package dev.challenge.callanalyzer.service;

import dev.challenge.callanalyzer.model.dto.CategoryDto;
import dev.challenge.callanalyzer.model.entity.Category;
import dev.challenge.callanalyzer.model.mapper.CategoryMapper;
import dev.challenge.callanalyzer.model.request.CategoryRequest;
import dev.challenge.callanalyzer.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final PointService pointService;
    private final CategoryMapper categoryMapper;

    private List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public CategoryDto createCategory(CategoryRequest request){
        Category category = categoryMapper.mapRequestToCategory(request);
        categoryRepository.save(category);
        request.points().forEach(point -> pointService.createPoint(category, point));
        return categoryMapper.mapCategoryToDto(category, pointService.getPointsByCategory(category));
    }

    public List<CategoryDto> getAllCategories(){
        return findAllCategories().stream()
                .map(category -> categoryMapper.mapCategoryToDto(category, pointService
                        .getPointsByCategory(category)))
                .toList();
    }
}
