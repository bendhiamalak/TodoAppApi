package com.Malek.todo.controllers.api;

import com.Malek.todo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
public interface UserApi {

    @PostMapping
    ResponseEntity<UserDto> createUser(@RequestBody UserDto user);

    @PutMapping("/{id}")
    ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user);

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUser(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id);
}
