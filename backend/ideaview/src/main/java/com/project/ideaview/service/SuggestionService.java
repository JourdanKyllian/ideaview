package com.project.ideaview.service;

import com.project.ideaview.model.Suggestion;
import com.project.ideaview.model.Task;
import com.project.ideaview.model.User;
import com.project.ideaview.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
     * Méthode qui permet de faire le register d'un user
     * @param suggestion
     * @return
     */
    public Suggestion saveSuggestion(Suggestion suggestion){
        return this.suggestionRepository.save(suggestion);
    }

    public Suggestion byUserIdSuggestion(Integer id){
        return this.suggestionRepository.findById(id).orElse(new Suggestion());
    }
}
