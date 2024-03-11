package com.project.ideaview.service;

import com.project.ideaview.model.Administrator;
import com.project.ideaview.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    public List<Administrator> getAllAdministrator(){
        return this.administratorRepository.findAll();
    }

    /**
     * Méthode qui permet de faire l'ajout et la modification<br>
     * - l'ajout : id = null <br>
     * - modification : id != null
     * @param administrator
     * @return
     */
    public Administrator saveAdministrator(Administrator administrator){
        return this.administratorRepository.save(administrator);
    }

    /**
     * recupere toute les tache d'un projet
     * @param id
     * @return
     */
    public Administrator byUserIdAdministrator(Integer id){
        return this.administratorRepository.findById(id).orElse(new Administrator());
    }
}
