package com.LaboratuvarApp.service;

import com.LaboratuvarApp.LaborantlarRepository;
import com.LaboratuvarApp.models.Hastalar;
import com.LaboratuvarApp.models.Laborantlar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaborantlarService {

    @Autowired
    public LaborantlarRepository laborantlarRepository;

    public List<Laborantlar> getLaborantlar(){

        return (List<Laborantlar>) laborantlarRepository.findAll();
    }



    public Optional<Laborantlar> getLaborantlarById(Integer Id){

        return laborantlarRepository.findById(Id);
    }



}
