package com.project.ideaview.controller;

import com.project.ideaview.model.News;
import com.project.ideaview.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * Méthode qui permet de faire l'ajout et la modification<br>
     * @param news
     * @return
     */
    @PostMapping("/news-project")
    public News newProjectNews(@ModelAttribute News news){
        this.newsService.saveNews(news);
        return news;
    }

    /**
     * recupere toutes les news par projet
     * @return
     */
    @GetMapping("/project")
    public List<News> project(@ModelAttribute News news){
        return this.newsService.getNewsByProject(news);
    }

    /**
     * recupere toutes les news par utilisateur
     * @return
     */
    @GetMapping("/user")
    public List<News> user(@ModelAttribute News news){
        return this.newsService.getNewsByUser(news);
    }
}
