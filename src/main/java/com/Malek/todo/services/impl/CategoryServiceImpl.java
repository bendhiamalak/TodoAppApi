package com.Malek.todo.services.impl;

import com.Malek.todo.dto.CategoryDto;
import com.Malek.todo.exception.ErrorCodes;
import com.Malek.todo.exception.InvalidEntityException;
import com.Malek.todo.repositories.CategoryRepository;
import com.Malek.todo.services.CategoryService;
import com.Malek.todo.validators.CategoryValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto category) {
        List<String> errors= CategoryValidator.validateCategory(category);
        if (!errors.isEmpty()){
            log.error("Category is not valid {}",category);
            throw new InvalidEntityException("Category is not valid", ErrorCodes.CATEGORY_NOT_VALID,errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(category)));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        if (id == null){
            log.error("Category id is null");
            return null;
        }
        return categoryRepository.findById(id).map(CategoryDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No Category found with ID = "+id,ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAllByUserId(long userId) {
        return CategoryRepository.findCategoryByUserId(userId).stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<CategoryDto> getAllTodoByCategoriesForToday(Long userId) {
        return List.of();
    }
}
