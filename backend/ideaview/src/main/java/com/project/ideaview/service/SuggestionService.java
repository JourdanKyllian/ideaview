package com.project.ideaview.service;

import com.project.ideaview.model.Suggestion;
import com.project.ideaview.model.Task;
import com.project.ideaview.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;

    public List<Suggestion> getAll(){
        return this.suggestionRepository.findAll();
    }
}
