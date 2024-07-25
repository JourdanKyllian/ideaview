package com.project.ideaview.controller;

import com.project.ideaview.model.Profile;
import com.project.ideaview.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    /**
     * Route qui permet de faire l'ajout et la modification d'un profile
     * @param profile
     * @return
     */
    @PostMapping("/save")
    public Profile saveProfile(@RequestBody Profile profile){
        return this.profileService.saveProfile(profile);
    }

    /**
     * recupere le profile d'un utilisateur avec son id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Profile getProfileById(@PathVariable Integer id){
        return this.profileService.getProfileById(id);
    }

}
