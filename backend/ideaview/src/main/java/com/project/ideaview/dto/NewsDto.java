package com.project.ideaview.dto;

import com.project.ideaview.model.News;
import lombok.Data;

import java.util.Date;

@Data
public class NewsDto {

    private String title;
    private String content;

    public News getNews() {
        News news = new News();
        news.setTitle(this.title);
        news.setContent(this.content);
        news.setDateCreation(new Date());
        return news;
    }
}
