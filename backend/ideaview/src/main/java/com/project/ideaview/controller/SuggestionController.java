package com.project.ideaview.controller;

import com.project.ideaview.model.Suggestion;
import com.project.ideaview.model.Task;
import com.project.ideaview.model.User;
import com.project.ideaview.service.SuggestionService;
import com.project.ideaview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/suggestion")
    public List<Suggestion> suggestion(){
        return this.suggestionService.getAllSuggestion();
    }

    @DeleteMapping("/suggestion/{id}")
    public Suggestion deleteSuggestion(@PathVariable Integer id){
        Suggestion suggestion = this.suggestionService.byUserIdSuggestion(id);
        suggestion.setActive(!suggestion.isActive());
        this.suggestionService.saveSuggestion(suggestion);
        return suggestion;
    }

    @PostMapping("/dashboard/suggestion")
    public Suggestion recupFormArticle(@ModelAttribute Suggestion suggestion){
        this.suggestionService.saveSuggestion(suggestion);
        return suggestion;
    }
}
