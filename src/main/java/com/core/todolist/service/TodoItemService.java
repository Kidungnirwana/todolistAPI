package com.core.todolist.service;

import com.core.todolist.model.TodoItem;
import com.core.todolist.repository.TodoItemRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class TodoItemService {

    @Getter
    private TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository) {

        this.todoItemRepository = todoItemRepository;
    }

    public Iterable<TodoItem> findAll(){

        return todoItemRepository.findAll();
    }

    public TodoItem findById(Long id){
        Optional<TodoItem> todoItem = todoItemRepository.findById(id);
        if (todoItem.isEmpty()){
            throw new IllegalStateException("Todo list not found....");
        }
        return todoItem.get();
    }

    public TodoItem create(TodoItem todoItem){

        todoItem = todoItemRepository.save(todoItem);
        todoItem.setCreatedAt(Instant.now());

        return todoItem;
    }

    public TodoItem update(Long id, TodoItem todoItem){

            Optional<TodoItem> item = todoItemRepository.findById(id);
            TodoItem updateItem = new TodoItem();
            if (item.isPresent()){

                updateItem = item.get();
                updateItem.setTodoName(todoItem.getTodoName());
                updateItem.setDescription(todoItem.getDescription());
                updateItem.setComplete(todoItem.isComplete());
                updateItem.setModifiedAt(Instant.now());
                updateItem = todoItemRepository.save(updateItem);
            }
            return updateItem;
    }

    public void deleteById (Long id) {
        Optional<TodoItem> todoItem = todoItemRepository.findById(id);
        if (todoItem.isEmpty()) {
            throw new IllegalStateException("User not exist...");
        }
        todoItemRepository.deleteById(id);
    }

    public void deleteAll () {

        todoItemRepository.deleteAll();
    }
}
