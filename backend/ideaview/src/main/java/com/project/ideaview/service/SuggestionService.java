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

    /**
     * Méthode qui permet de faire l'affichage d'une suggestion<br>
     * @return
     */
    public List<Suggestion> getAllSuggestion(){
        List<Suggestion> suggestions = new ArrayList<>();
        suggestions = this.suggestionRepository.findAll();
        return suggestions;
    }

    /**
     * Méthode qui permet de faire l'affichage d'une suggestion si active = true<br>
     * @return
     */
    public List<Suggestion> getAllSuggestionActive(){
        List<Suggestion> suggestions = new ArrayList<>();
        suggestions = this.suggestionRepository.findByActiveIsTrue();
        return suggestions;
    }

    /**
     * Méthode qui permet de faire l'ajout d'une suggestion<br>
     * @param suggestion
     * @return
     */
    public Suggestion createSuggestion(Suggestion suggestion){
        return this.suggestionRepository.save(suggestion);
    }

    /**
     * Methode qui permet de faire l'archive d'une suggestion<br>
     * @param id
     * @return
     */
    public Suggestion deleteSuggestion(Integer id){
        Suggestion suggestion = this.suggestionRepository.findById(id).get();
        suggestion.setActive(false);
        return this.suggestionRepository.save(suggestion);
    }
}
