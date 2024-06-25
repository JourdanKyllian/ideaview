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
    public News saveNews(News news){
        return this.newsRepository.save(news);
    }

    /**
     * recupere toute les news
     * @return
     */
    public List<News> getAllNews(){
        return this.newsRepository.findAll();
    }

//    /**
//     * recupere toute les news d'un projet
//     * @return
//     */
//    public List<News> getNewsByProject(Integer projectId){
//        return this.newsRepository.findByProjectId(projectId);
//    }

//    /**
//     * recupere toute les news d'un user
//     * @return
//     */
//    public List<News> getNewsByUsers(Integer usersId){
//        return this.newsRepository.findByUsersId(usersId);
//    }
}
