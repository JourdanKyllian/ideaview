package com.project.ideaview.controller;

import com.project.ideaview.model.Users;
import com.project.ideaview.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    public List<Users> user(){
        return this.usersService.getAll();
    }

    @PostMapping("/dashboard/register")
    public Users recupFormRegister(@ModelAttribute Users user) {
        this.usersService.save(user);
        return user;
    }

}