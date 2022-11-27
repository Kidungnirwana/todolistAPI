package com.core.todolist.controller;

import com.core.todolist.model.User;
import com.core.todolist.service.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Getter
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @RequestMapping("/create")
    public User createOne(@RequestBody User user){

        return userService.create(user);
    }

    @GetMapping
    @RequestMapping("/all")
    public Iterable<User>findAll(){

        return userService.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public User findById(@PathVariable("id") Long id){

        return userService.findById(id);
    }

    @PutMapping
    @RequestMapping("/update/{id}")
    public User updateOne(@PathVariable("id") Long id ,@RequestBody User user){

        return userService.update(id, user);
    }

    @DeleteMapping
    @RequestMapping("delete/{id}")
    public void deleteById (@PathVariable("id") Long id) {

        userService.deleteById(id);
    }

    @DeleteMapping
    @RequestMapping("delete/all")
    public void  format() {

        userService.deleteAll();
    }
}
