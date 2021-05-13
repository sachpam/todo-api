package com.api.todoapi.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Todo {
    @Id @GeneratedValue
    private Integer id;
    private String todo;
    private boolean is_complete;

    public Todo() {
    }
    public Todo(Integer id, String todo, boolean is_complete) {
        this.id = id;
        this.todo = todo;
        this.is_complete = is_complete;
    }
    public Todo(String todo, boolean is_complete) {
        this.todo = todo;
        this.is_complete = is_complete;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
    public boolean isIs_complete() {
        return is_complete;
    }
    public void setIs_complete(boolean is_complete) {
        this.is_complete = is_complete;
    }
    @Override
    public String toString() {
        return "Todo [id=" + id + ", is_complete=" + is_complete + ", todo=" + todo + "]";
    }

    

    
}
