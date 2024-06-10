package com.project.ideaview.service;

import com.project.ideaview.model.News;
import com.project.ideaview.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    /**
     * Méthode qui permet de faire l'ajout<br>
     */
    public void saveNews(News news){
        this.newsRepository.save(news);
    }

    /**
     * recupere toute les news d'un projet
     * @return
     */
    public List<News> getNewsByProject(News news){
        return this.newsRepository.findById(projectId).orElse(null);
    }

    /**
     * recupere toute les news d'un user
     * @return
     */
    public List<News> getNewsByUser(News news){
        return this.newsRepository.findById(userId).orElse(null);
    }
}
