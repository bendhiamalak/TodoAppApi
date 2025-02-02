package com.Malek.todo.services;

import com.Malek.todo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto category);
    List<CategoryDto> findAll();
    CategoryDto findById(long id);
    List<CategoryDto> findAllByUserId(long userId);
    void delete(long id);
    List<CategoryDto> getAllTodoByCategoriesForToday(Long userId);
}
