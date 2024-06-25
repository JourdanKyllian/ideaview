package com.project.ideaview.service;

import com.project.ideaview.model.Arborescence;
import com.project.ideaview.repository.ArborescenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class ArborescenceService {
    @Autowired
    private ArborescenceRepository arborescenceRepository;
    public List<Arborescence> getAllArborescence(){
        return this.arborescenceRepository.findAll();
    }

    public Arborescence saveArborescence(Arborescence arborescence){
        return this.arborescenceRepository.save(arborescence);
    }

    public void deleteArborescence(Integer id){
        this.arborescenceRepository.deleteById(id);
    }
}