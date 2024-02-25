package com.project.ideaview.controller;

import com.project.ideaview.model.Task;
import com.project.ideaview.model.User;
import com.project.ideaview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> user(){
        return this.userService.getAll();
    }

    @DeleteMapping("/task/{id}")
    public User deleteTask(@PathVariable Integer id){
        User user = this.userService.byUserId(id);
        user.setActive(!user.isActive());
        this.userService.saveUser(user);
        return user;
    }

    @PostMapping("/dashboard/register")
    public User recupFormRegister(@ModelAttribute User user) {
        this.userService.saveUser(user);
        return user;
    }
}