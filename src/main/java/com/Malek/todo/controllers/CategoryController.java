package com.Malek.todo.controllers;

import com.Malek.todo.controllers.api.CategoryApi;
import com.Malek.todo.dto.CategoryDto;

import com.Malek.todo.services.CategoryService;
import com.Malek.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge = 3688)
public class CategoryController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TodoService todoService;

    @Override
    public ResponseEntity<CategoryDto>createCategory(CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.save(categoryDto),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDto>updateCategory(CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.save(categoryDto),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllTodoByCategoriesId(Long id){
        return new ResponseEntity<>(todoService.findByCategory(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(Long id){
        return new ResponseEntity<>(CategoryService.findAllByUserId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> getCategory(Long id){
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long id){
        categoryService.delete(id);
        return ResponseEntity.ok("Catrgorie supprimee avec succes");
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllTodoByCategoriesForToday(long userId){
        return new ResponseEntity<>(categoryService.getAllTodoByCategoriesForToday(userId),HttpStatus.OK);
    }



}
