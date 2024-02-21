package com.project.ideaview.controller;

import com.project.ideaview.model.Suggestion;
import com.project.ideaview.model.Task;
import com.project.ideaview.service.SuggestionService;
import com.project.ideaview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/suggestion")
    public List<Suggestion> suggestion(){
        return this.suggestionService.getAll();
    }
}
