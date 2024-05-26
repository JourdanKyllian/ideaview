package com.project.ideaview.service;

import com.project.ideaview.model.Users;
import com.project.ideaview.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAll() {
        return this.usersRepository.findAll();
    }

    /**
     * Méthode qui permet de faire le register d'un user
     * @param users
     * @return
     */
    public Users save(Users users){
        return usersRepository.save(users);
    }

    public Users findByEmail(String email){
        if (email == null) {
            return null;
        }
        return usersRepository.findByEmail(email.toLowerCase().trim());
    }

    public Users findByToken(String token){
        if (token == null) {
            return null;
        }
        return usersRepository.findByToken(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

}
