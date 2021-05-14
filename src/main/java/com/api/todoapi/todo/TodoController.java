package com.api.todoapi.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

   
    @GetMapping
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @PostMapping
    public boolean addTodo(@RequestBody Todo todo){
        todoService.addNewTodo(todo);
        return true;
        
    }

    @DeleteMapping(path = "{todoId}")
    public void removeTodo(@PathVariable("todoId") Integer id){
        todoService.deleteTodo(id);
    }

    @PutMapping(path = "{todoId}")
    public void updateTodo(@PathVariable("todoId") Integer id, @RequestBody Todo todo) {
        todoService.updateTodo(id, todo);
    }
    
}
