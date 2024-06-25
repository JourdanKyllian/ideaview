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
     * Méthode qui permet de faire l'affichage d'une suggestion si active = 0<br>
     * @return
     */
    public List<Suggestion> getAllSuggestionArchived(){
        List<Suggestion> suggestions = new ArrayList<>();
        suggestions = this.suggestionRepository.findByActiveIsFalse();
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
     * Méthode qui archive une suggestion en passant active à false
     * @param id
     * @return
     */
    public Suggestion archiveSuggestion(Integer id){
        Suggestion suggestion = this.suggestionRepository.findById(id).orElse(new Suggestion());
        suggestion.setActive(false);
        return this.suggestionRepository.save(suggestion);
    }

    /**
     * Méthode qui delete une suggestion
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
