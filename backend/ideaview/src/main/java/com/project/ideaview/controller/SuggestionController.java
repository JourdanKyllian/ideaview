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
        return this.suggestionService.getAllSuggestionActive();
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
    @PostMapping("/delete/{id}")
    public Suggestion archiveSuggestion(@PathVariable Integer id){
        return this.suggestionService.deleteSuggestion(id);
    }
}
