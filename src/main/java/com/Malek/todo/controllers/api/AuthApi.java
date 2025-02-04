package com.Malek.todo.controllers.api;

import com.Malek.todo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface AuthApi {

    @GetMapping
    public ResponseEntity<UserDto> login(@RequestBody UserDto user);

}
