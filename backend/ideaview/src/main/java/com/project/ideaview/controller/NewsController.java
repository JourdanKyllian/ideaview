package com.project.ideaview.controller;

import com.project.ideaview.dto.NewsDto;
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
     * @param
     * @return
     */
    @PostMapping("/save")
    public News createNews(@RequestBody NewsDto newsDto){
        return this.newsService.saveNews(newsDto.getNews());
    }

    /**
     * recupere toutes les news<br>
     * @return
     */
    @GetMapping("/list")
    public List<News> getAllNews(){
        return this.newsService.getAllNews();
    }

//    /**
//     * recupere toutes les news par projet<br>
//     * @param projectId
//     * @return
//     */
//    @GetMapping("/news/project/{projectId}")
//    public List<News> project(@PathVariable Integer projectId){
//        return this.newsService.getNewsByProject(projectId);
//    }

//    /**
//     * recupere toutes les news par utilisateur<br>
//     * @param usersId
//     * @return
//     */
//    @GetMapping("/news/users/{usersId}")
//    public List<News> user(@PathVariable Integer usersId){
//        return this.newsService.getNewsByUsers(usersId);
//    }
}
