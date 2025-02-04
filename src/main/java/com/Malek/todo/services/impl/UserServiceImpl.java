package com.Malek.todo.services.impl;

import com.Malek.todo.dto.UserDto;
import com.Malek.todo.exception.EntityNotFoundException;
import com.Malek.todo.exception.ErrorCodes;
import com.Malek.todo.exception.InvalidEntityException;
import com.Malek.todo.repositories.UserRepository;
import com.Malek.todo.services.UserService;
import com.Malek.todo.validators.UserValidator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.Malek.todo.dto.UserDto.toEntity;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        List<String> errors = UserValidator.validateUser(userDto);
        if(!errors.isEmpty()) {
            log.error("User not valid {}",userDto);
            throw new InvalidEntityException("User not valid !", ErrorCodes.USER_NOT_VALID,errors);
        }
        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(userDto)));

    }

    @Override
    public List<UserDto> findAll(){
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        if (id == null){
            log.error("id is null");
            return null;
        }
        return userRepository.findById(id).map(UserDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("User not found avec Id="+id,ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public void delete(Long id){
        if (id == null){
            log.error("id is null");
            throw new InvalidEntityException("No user found with id "+id ,ErrorCodes.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto login(UserDto user) {
        if (user == null || user.getEmail() == null || user.getPassword() == null) {
            throw new InvalidEntityException("Email and Password must not be null", ErrorCodes.USER_NOT_VALID);
        }

        List<String> errors = UserValidator.validateUserCredential(user.getEmail(), user.getPassword());
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_VALID, errors);
        }

        return Optional.ofNullable(userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword()))
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user found with Email = " + user.getEmail() + " and Password = <HIDDEN_PASSWORD>", ErrorCodes.USER_NOT_FOUND));
    }


}
