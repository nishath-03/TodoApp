package com.example.TodoApp;

import com.example.TodoApp.model.Todo;
import com.example.TodoApp.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    public Todo addTodo(Todo todo) {
        return repo.save(todo);
    }

    public void deleteTodo(int id) {
        repo.deleteById(id);
    }

    public Todo updateTodo(int id, Todo updatedTodo) {
        Todo todo = repo.findById(id).orElse(null);

        if (todo != null) {
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompleted(updatedTodo.isCompleted());
            todo.setPriority(updatedTodo.getPriority());
            return repo.save(todo);
        }

        return null;
    }
}








//package com.example.TodoApp;
//
//import com.example.TodoApp.model.Todo;
//import org.springframework.stereotype.Service;
//import java.util.*;
//
//@Service
//public class TodoService {
//    private List<Todo> todos = new ArrayList<>();
//
//    public List<Todo> getAllTodos(){
//        return todos;
//    }
//    public Todo addTodo(Todo todo){
//        todos.add(todo);
//        return todo;
//    }
//    public void delete(int id){
//        for(int i=0;i<todos.size();i++){
//            Todo todo = todos.get(i);
//            if(todo.getId()==id) {todos.remove(i);break;}
//        }
//    }
//    public Todo update(int id, Todo updateTodo){
//        for(int i=0;i<todos.size();i++){
//            Todo todo = todos.get(i);
//            if(todo.getId() == id){
//                todo.setTitle(updateTodo.getTitle());
//                todo.setDescription(updateTodo.getDescription());
//                todo.setCompleted(updateTodo.isCompleted());
//                return todo;
//            }
//        }return null;
//    }
//}
