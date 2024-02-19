package com.project.ideaview.service;

import com.project.ideaview.model.User;
import com.project.ideaview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Méthode qui permet de faire le register d'un user
     * @param user
     * @return
     */
    public User saveUser(User user){
        return this.userRepository.save(user);
    }
}
