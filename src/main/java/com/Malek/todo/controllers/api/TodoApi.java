package com.Malek.todo.controllers.api;

import com.Malek.todo.dto.TodoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/todo")
public interface TodoApi {

    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto userDto);

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id,@RequestBody TodoDto todoDto);



    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos();

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long todoId);

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId);

}
