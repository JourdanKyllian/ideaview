package com.project.ideaview.service;

import com.project.ideaview.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;
    public List getAll(){
        List<String> maReponse = new ArrayList<String>();
        maReponse.add("ma reponse");
        return maReponse ;
    }
}
