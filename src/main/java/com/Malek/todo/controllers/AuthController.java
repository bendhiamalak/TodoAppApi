package com.Malek.todo.controllers;


import com.Malek.todo.controllers.api.AuthApi;
import com.Malek.todo.dto.UserDto;
import com.Malek.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController implements AuthApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDto> login(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }



}
