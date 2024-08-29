package com.project.ideaview.controller;

import com.project.ideaview.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * route qui permet d'obtenir les détails de la personne loggée
     */

}