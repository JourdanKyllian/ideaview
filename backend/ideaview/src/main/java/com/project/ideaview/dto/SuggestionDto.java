package com.project.ideaview.dto;

import com.project.ideaview.model.Suggestion;
import lombok.Data;

import java.util.Date;

@Data
public class SuggestionDto {

    private String title;
    private String content;

    public Suggestion getSuggestion() {
        Suggestion suggestion = new Suggestion();
        suggestion.setTitle(this.title);
        suggestion.setContent(this.content);
        suggestion.setDateCreation(new Date());
        suggestion.setActive(true);
        suggestion.setStatus("En cours de truc");
        return suggestion;
    }
}
