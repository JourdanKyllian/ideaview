package com.project.ideaview.controller;

import com.project.ideaview.dto.SuggestionDto;
import com.project.ideaview.model.Suggestion;
import com.project.ideaview.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    /**
     * Route qui retourne toutes les suggestions d'un projet
     * @return
     */
    @GetMapping("/suggestionlist")
    public List<Suggestion> getAllSuggestion(){
        return this.suggestionService.getAllSuggestion();
    }

    /**
     * Route qui retourne toutes les suggestions archivés d'un projet
     * @return
     */
    @GetMapping("/suggestionlistarchived")
    public List<Suggestion> getAllSuggestionArchived(){
        return this.suggestionService.getAllSuggestionArchived();
    }

    /**
     * Route qui permet de faire l'ajout d'une suggestion<br>
     * @param suggestionDto
     * @return
     */
    @PostMapping("/suggestionsave")
    public Suggestion createSuggestion(@RequestBody SuggestionDto suggestionDto){
        return this.suggestionService.createSuggestion(suggestionDto.getSuggestion());
    }

    /**
     * Route qui permet de faire l'archive d'une suggestion<br>
     * @param id
     * @return
     */
    @PostMapping("/suggestionarchive/{id}")
    public Suggestion archiveSuggestion(@PathVariable Integer id){
        return this.suggestionService.archiveSuggestion(id);
    }

    /**
     * Route qui permet de faire la suppression d'une suggestion<br>
     * @param id
     */
    @DeleteMapping("/dashboard/suggestiondell/{id}")
    public void deleteSuggestion(@PathVariable Integer id){
        this.suggestionService.deleteSuggestion(this.suggestionService.bySuggestionId(id));
    }
}
