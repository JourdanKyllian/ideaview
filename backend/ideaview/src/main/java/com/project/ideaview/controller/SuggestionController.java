package com.project.ideaview.controller;

import com.project.ideaview.dto.SuggestionDto;
import com.project.ideaview.model.Suggestion;
import com.project.ideaview.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/suggestion")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    /**
     * Route qui retourne toutes les suggestions d'un projet
     * @return
     */
    @GetMapping("/list")
    public List<Suggestion> getAllSuggestion(){
        return this.suggestionService.getAllSuggestion();
    }

    /**
     * Route qui retourne toutes les suggestions archivés d'un projet
     * @return
     */
    @GetMapping("/archived/list")
    public List<Suggestion> getAllSuggestionArchived(){
        return this.suggestionService.getAllSuggestionArchived();
    }

    /**
     * Route qui permet de faire l'ajout d'une suggestion<br>
     * @param suggestionDto
     * @return
     */
    @PostMapping("/save")
    public Suggestion createSuggestion(@RequestBody SuggestionDto suggestionDto){
        return this.suggestionService.createSuggestion(suggestionDto.getSuggestion());
    }

    /**
     * Route qui permet de faire l'archive d'une suggestion<br>
     * @param id
     * @return
     */
    @PostMapping("/dashboard/archive/{id}")
    public Suggestion archiveSuggestion(@PathVariable Integer id){
        return this.suggestionService.archiveSuggestion(id);
    }

    /**
     * Route qui permet de faire la suppression d'une suggestion<br>
     * @param id
     */
    @DeleteMapping("/dashboard/delete/{id}")
    public void deleteSuggestion(@PathVariable Integer id){
        this.suggestionService.deleteSuggestion(this.suggestionService.bySuggestionId(id));
    }
}
