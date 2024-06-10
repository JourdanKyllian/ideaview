package com.project.ideaview.controller;

import com.project.ideaview.model.Administrator;
import com.project.ideaview.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/administrator")
    public List<Administrator> news(){
        return this.administratorService.getAllAdministrator();
    }

    @DeleteMapping("/administrator/{id}")
    public Administrator deleteAdministrator(@PathVariable Integer id){
        Administrator administrator = this.administratorService.byUserIdAdministrator(id);
        administrator.setAdmin(!administrator.isAdmin());
        this.administratorService.saveAdministrator(administrator);
        return administrator;
    }

    @PostMapping("/dashboard/administrator")
    public Administrator recupFormAdministrator(@ModelAttribute Administrator administrator){
        this.administratorService.saveAdministrator(administrator);
        return administrator;
    }
}
