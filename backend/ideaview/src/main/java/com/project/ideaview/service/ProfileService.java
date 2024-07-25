package com.project.ideaview.service;

import com.project.ideaview.model.Profile;
import com.project.ideaview.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    /**
     * Méthode qui permet de faire l'ajout et la modification d'un profile
     * @param profile
     * @return
     */
    public Profile saveProfile(Profile profile){
        return this.profileRepository.save(profile);
    }

    /**
     * recupere le profile d'un utilisateur avec son id
     * @param id
     * @return
     */
    public Profile getProfileById(Integer id){
        return this.profileRepository.findById(id).orElse(new Profile());
    }

}
