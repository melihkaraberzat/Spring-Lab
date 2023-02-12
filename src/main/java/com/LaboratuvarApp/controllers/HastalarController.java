package com.LaboratuvarApp.controllers;

import com.LaboratuvarApp.UserRepository;
import com.LaboratuvarApp.models.User;
import com.LaboratuvarApp.service.HastalarService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.LaboratuvarApp.models.Hastalar;
import com.LaboratuvarApp.service.UserService;
import com.LaboratuvarApp.service.HastalarService;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;
import java.util.Optional;

@Controller
public class HastalarController {
    @Autowired
    public UserService userService;
    @Autowired
    public HastalarService hastalarService;


    @GetMapping("/hastalar")
    public String getHastalar(Model model){
        model.addAttribute("hastalar",hastalarService.getHastalar());
        return "hastalar";
    }

    @RequestMapping(value = "/addNew",method = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET})
    public String addHastalar(Hastalar hastalar){
        hastalarService.addHasta(hastalar);
        return "redirect:/hastalar";
    }







}
