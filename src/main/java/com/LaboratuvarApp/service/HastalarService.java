package com.LaboratuvarApp.service;


import com.LaboratuvarApp.HastalarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LaboratuvarApp.models.Hastalar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HastalarService {
    @Autowired
    public HastalarRepository hastalarRepository;
    public List<Hastalar> getHastalar(){

        return (List<Hastalar>) hastalarRepository.findAll();
    }


    public Optional<Hastalar>getHastalarById(Integer Id){

        return hastalarRepository.findById(Id);
    }


    public void addHasta(Hastalar hastalar){
        hastalarRepository.save(hastalar);
    }



    public void deleteHastalar(Integer Id){
        hastalarRepository.deleteById(Id);
    }




    public Hastalar updateHastalar (Hastalar hastalar){
        return hastalarRepository.save(hastalar);
    }








}
