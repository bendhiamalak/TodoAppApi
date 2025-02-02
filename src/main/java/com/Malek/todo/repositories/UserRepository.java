package com.Malek.todo.repositories;

import com.Malek.todo.dto.UserDto;
import com.Malek.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByEmailAndPassword (String email, String password);

}
