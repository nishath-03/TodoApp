package com.example.TodoApp;

import com.example.TodoApp.model.Todo;
import com.example.TodoApp.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // get all todos
    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    // create todo
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    // update todo
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    // delete todo
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return "Deleted successfully";
    }
}