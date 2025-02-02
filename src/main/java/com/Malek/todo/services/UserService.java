package com.Malek.todo.services;

import com.Malek.todo.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto save(UserDto userDto);
    public List<UserDto> findAll();
    public UserDto findById(Long id);
    public void delete(Long id);
    public UserDto login(UserDto user);
}
