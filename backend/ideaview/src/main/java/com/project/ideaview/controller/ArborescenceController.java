package com.project.ideaview.controller;

import com.project.ideaview.model.Arborescence;
import com.project.ideaview.service.ArborescenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ArborescenceController {
    @Autowired
    private ArborescenceService arborescenceService;

    @GetMapping("/arborescence")
    public List<Arborescence> arborescence(){
        return this.arborescenceService.getAllArborescence();
    }

    @PostMapping("/dashboard/arborescence")
    public Arborescence recupFormArborescence(@ModelAttribute Arborescence arborescence) {
        this.arborescenceService.saveArborescence(arborescence);
        return arborescence;
    }
}
