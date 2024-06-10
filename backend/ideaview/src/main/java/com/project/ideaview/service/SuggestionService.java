package com.project.ideaview.service;

import com.project.ideaview.model.Suggestion;
import com.project.ideaview.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;

    public List<Suggestion> getAllSuggestion(){
        return this.suggestionRepository.findAll();
    }

    /**
     * Méthode qui permet de faire l'ajout d'une suggestion<br>
     * @param suggestion
     * @return
     */
    public Suggestion saveSuggestion(Suggestion suggestion){
        return this.suggestionRepository.save(suggestion);
    }

    /**
     * Méthode qui permet de supprimer une suggestion
     * @param suggestion
     */
    public void deleteSuggestion(Suggestion suggestion){
        this.suggestionRepository.delete(suggestion);
    }
    /**
     * recupere toute les user d'un projet
     * @param id
     * @return
     */
    public Suggestion bySuggestionId(Integer id){
        return this.suggestionRepository.findById(id).orElse(new Suggestion());
    }
}
