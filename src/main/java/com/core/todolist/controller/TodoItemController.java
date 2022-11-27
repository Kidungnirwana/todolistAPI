package com.core.todolist.controller;

import com.core.todolist.model.TodoItem;
import com.core.todolist.service.TodoItemService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoItemController {

    @Getter
    private TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    @RequestMapping("/all")
    public Iterable<TodoItem> findAll(){

        return todoItemService.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public TodoItem findById(@PathVariable("id") Long id){

        return todoItemService.findById(id);
    }

    @PostMapping
    @RequestMapping("/create")
    public TodoItem createOne(@RequestBody TodoItem todoItem){

        return todoItemService.create(todoItem);
    }

    @PutMapping
    @RequestMapping("/update/{id}")
    public TodoItem updateOne(@PathVariable("id") Long id, @RequestBody TodoItem todoItem){

        return todoItemService.update(id, todoItem);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteById (@PathVariable("id") Long id) {

        todoItemService.deleteById(id);
    }

    @DeleteMapping
    @RequestMapping("delete/all")
    public void deleteAll() {

        todoItemService.deleteAll();
    }
}
