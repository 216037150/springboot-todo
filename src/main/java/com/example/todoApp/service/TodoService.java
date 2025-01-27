package com.example.todoApp.service;

import com.example.todoApp.model.TodoItem;
import com.example.todoApp.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoItem save(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }
}
