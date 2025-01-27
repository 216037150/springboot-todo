package com.example.todoApp.Controller;

import com.example.todoApp.model.TodoItem;
import com.example.todoApp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping("/post")
    public TodoItem save(@RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }


    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> update(@PathVariable long id, @RequestBody TodoItem updatedTodoItem) {
        Optional<TodoItem> existingTodo = todoRepository.findById(id);
        if (existingTodo.isPresent()) {
            TodoItem todo = existingTodo.get();
            todo.setTitle(updatedTodoItem.getTitle());
            todo.setIsDone(updatedTodoItem.isDone());
            return ResponseEntity.ok(todoRepository.save(todo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
