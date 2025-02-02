package com.Malek.todo.controllers.api;

import com.Malek.todo.dto.CategoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryApi {

    public ResponseEntity<CategoryDto>createCategory(CategoryDto categoryDto);

    public ResponseEntity<CategoryDto> updateCategory(CategoryDto categoryDto);
    public ResponseEntity<List<CategoryDto>> getAllCategories();

    public ResponseEntity<List<CategoryDto>> getAllTodoByCategoriesId(Long id);

    public ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(Long id);

    public ResponseEntity<CategoryDto> getCategory(Long id);
    public ResponseEntity deleteCategory(Long id);

    public ResponseEntity<List<CategoryDto>> getAllTodoByCategoriesForToday(long userId);

}
