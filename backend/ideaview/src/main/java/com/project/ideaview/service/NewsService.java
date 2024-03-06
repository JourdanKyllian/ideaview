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
}
