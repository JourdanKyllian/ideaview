package com.project.ideaview.controller;

import com.project.ideaview.model.Suggestion;
import com.project.ideaview.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/suggestion")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    /**
     * Retourne toutes les suggestions d'un projet
     *
     */
    @GetMapping("/list")
    public List<Suggestion> listSuggestion(){
        return this.suggestionService.getAllSuggestion();
    }

    @PostMapping("/save")
    public Suggestion saveSuggestion(@RequestBody Suggestion suggestion){
        return this.suggestionService.saveSuggestion(suggestion);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSuggestion(@PathVariable Integer id){
        this.suggestionService.deleteSuggestion(this.suggestionService.bySuggestionId(id));
    }
}
