package com.project.ideaview.repository;

import com.project.ideaview.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
//    List<News> findByProjectId(Integer projectId);
//    List<News> findByUsersId(Integer usersId);
}
