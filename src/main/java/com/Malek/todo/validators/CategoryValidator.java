package com.Malek.todo.validators;

import com.Malek.todo.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validateCategory(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();
        if(categoryDto == null){
            errors.add("please fill the name");
            errors.add("please fill the description");
            return errors;
        }
        if (StringUtils.isEmpty(categoryDto.getName())){
            errors.add("please fill the name");
        }
        if (StringUtils.isEmpty(categoryDto.getDescription())){
            errors.add("please fill the description");
        }
        return errors;
    }
}
