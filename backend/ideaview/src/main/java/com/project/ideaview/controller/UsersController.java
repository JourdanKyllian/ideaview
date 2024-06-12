package com.project.ideaview.controller;

import com.project.ideaview.model.Users;
import com.project.ideaview.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;


}