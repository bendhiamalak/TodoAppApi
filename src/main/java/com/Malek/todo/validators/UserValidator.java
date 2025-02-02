package com.Malek.todo.validators;

import com.Malek.todo.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validateUser(UserDto userDto){
        List<String> errors = new ArrayList<>();
        if (userDto == null) {
            errors.add("User is null");
            return errors;
        }

        if (StringUtils.isEmpty(userDto.getUserName())){
            errors.add("Username is empty");
        }
        if (StringUtils.isEmpty(userDto.getPassword())){
            errors.add("Password is empty");
        }
        if (StringUtils.isEmpty(userDto.getEmail())){
            errors.add("Email is empty");
        }

        if (StringUtils.isEmpty(userDto.getFirstName())){
            errors.add("First name is empty");
        }
        if (StringUtils.isEmpty(userDto.getLastName())){
            errors.add("Last name is empty");
        }
        return errors;
    }

    public static List<String> validateUserCredential(String Email, String Password){
        List<String> errors = new ArrayList<>();

        if (StringUtils.isEmpty(Email)){
            errors.add("Email is empty");
        }
        if (StringUtils.isEmpty(Password)){
            errors.add("Password is empty");
        }
        return errors;
    }
}
