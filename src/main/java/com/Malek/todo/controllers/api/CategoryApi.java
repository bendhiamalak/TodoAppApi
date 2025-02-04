package com.Malek.todo.controllers.api;

import com.Malek.todo.dto.CategoryDto;
import com.Malek.todo.dto.TodoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cat")
public interface CategoryApi {

    @PostMapping
    ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto);

    @PutMapping("/{id}")
    ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto);

    @GetMapping
    ResponseEntity<List<CategoryDto>> getAllCategories();

    @GetMapping("/todos/{categoryId}")
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(@PathVariable Long categoryId);

    @GetMapping("/user/{userId}")
    ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(@PathVariable Long userId);

    @GetMapping("/{id}")
    ResponseEntity<CategoryDto> getCategory(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCategory(@PathVariable Long id);

    @GetMapping("/todos/today/{userId}")
    ResponseEntity<List<CategoryDto>> getAllTodoByCategoriesForToday(@PathVariable Long userId);
}