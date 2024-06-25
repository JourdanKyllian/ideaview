package com.project.ideaview.controller;

import com.project.ideaview.model.Arborescence;
import com.project.ideaview.service.ArborescenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ArborescenceController {

    @Autowired
    private ArborescenceService arborescenceService;

    /**
     * methode qui permet d'afficher un fichier de l'arborescence
     * @return
     */
    @GetMapping("/arborescencelist")
    public List<Arborescence> arborescence(){
        return this.arborescenceService.getAllArborescence();
    }

    /**
     * methode qui permet de faire l'ajout et la modification d'un fichier de l'arborescence
     * @param arborescence
     * @return
     */
    @PostMapping("/arborescence")
    public Arborescence saveArborescence(@RequestBody Arborescence arborescence){
        return this.arborescenceService.saveArborescence(arborescence);
    }

    //admin part

    /**
     * methode qui permet de supprimer un fichier de l'arborescence
     * @param id
     */
    @DeleteMapping("/dashboard/arborescence/{id}")
    public void deleteArborescence(@PathVariable Integer id){
        this.arborescenceService.deleteArborescence(id);
    }
}
