package com.api.todoapi.todo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }
  
    public void addNewTodo(Todo todo) {
		todoRepository.save(todo);
        
	}

    public void deleteTodo(Integer todoId){
        todoRepository.deleteById(todoId);
    }

    @Transactional
    public void updateTodo(Integer todoId, Todo todo) {
        Todo td = todoRepository.findById(todoId).orElseThrow(() -> new IllegalStateException("Todo with id " + todoId + " does not exist"));

        if (todo.getTodo() != null) {
            td.setTodo(todo.getTodo());
        }

        td.setIs_complete(todo.isIs_complete());
    }

    
}
