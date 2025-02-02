package com.Malek.todo.controllers.api;

import com.Malek.todo.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface AuthApi {

    public ResponseEntity<UserDto> login(UserDto user);

}
