package dev.challenge.callanalyzer.controller;

import dev.challenge.callanalyzer.model.dto.CategoryDto;
import dev.challenge.callanalyzer.model.entity.Category;
import dev.challenge.callanalyzer.model.request.CategoryRequest;
import dev.challenge.callanalyzer.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping()
    public CategoryDto createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }

    @GetMapping()
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

}
