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

    public List<News> getAllNews(){
        return this.newsRepository.findAll();
    }

    /**
     * Méthode qui permet de faire l'ajout et la modification<br>
     * - l'ajout : id = null <br>
     * - modification : id != null
     * @param news
     * @return
     */
    public News saveNews(News news){
        return this.newsRepository.save(news);
    }

    /**
     * recupere toute les tache d'un projet
     * @param id
     * @return
     */
    public News byUserIdNews(Integer id){
        return this.newsRepository.findById(id).orElse(new News());
    }
}
