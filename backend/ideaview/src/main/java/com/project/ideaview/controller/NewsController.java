package com.project.ideaview.controller;

import com.project.ideaview.model.News;
import com.project.ideaview.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public List<News> news(){
        return this.newsService.getAllNews();
    }

    @DeleteMapping("/news/{id}")
    public News deleteProject(@PathVariable Integer id){
        News news = this.newsService.byUserIdNews(id);
        news.setActive(!news.isActive());
        this.newsService.saveNews(news);
        return news;
    }

    @PostMapping("/dashboard/news")
    public News recupFormNews(@ModelAttribute News news){
        this.newsService.saveNews(news);
        return news;
    }
}
