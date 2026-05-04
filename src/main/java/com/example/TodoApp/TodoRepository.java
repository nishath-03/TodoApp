package com.example.TodoApp;

import com.example.TodoApp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
