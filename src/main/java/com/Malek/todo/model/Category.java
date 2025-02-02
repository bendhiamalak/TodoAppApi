package com.Malek.todo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    @ManyToMany
    @JoinColumn(name="userId")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "category", fetch=FetchType.EAGER)
    private List<Todo> todoList ;
}
