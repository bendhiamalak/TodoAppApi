package com.Malek.todo.services.impl;

import com.Malek.todo.dto.CategoryDto;
import com.Malek.todo.exception.ErrorCodes;

import com.Malek.todo.exception.InvalidEntityException;
import com.Malek.todo.repositories.CategoryRepository;
import com.Malek.todo.services.CategoryService;
import com.Malek.todo.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Malek.todo.exception.EntityNotFoundException;
import java.time.ZonedDateTime;
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
        if (id == null) {
            log.error("Category id is null");
            throw new InvalidEntityException("Category ID cannot be null", ErrorCodes.CATEGORY_NOT_VALID);
        }

        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Category found with ID = " + id, ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAllByUserId(Long userId) {
        return categoryRepository.findCategoryByUserId(userId).stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Category id is null");
            return;
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAllTodoByCategoriesForToday(Long userId) {

        return categoryRepository.getAllTodoByCategoriesForToday(ZonedDateTime.now().withHour(0).withMinute(0),
                ZonedDateTime.now().withHour(23).withMinute(59), userId)
                .stream()
                .map(CategoryDto :: fromEntity)
                .collect(Collectors.toList());
    }
}
