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

    @RequestMapping("/tekHasta/{id}")
    @ResponseBody
    public Optional<Hastalar> getHastaById(@PathVariable(value = "id")Integer id){
        return hastalarService.getHastalarById(id);
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteHastalar(@PathVariable(value = "id")Integer Id){
        hastalarService.deleteHastalar(Id);
        return "redirect:/hastalar";
    }

    @PostMapping(path = "/update/{id}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateHasta(@PathVariable(value = "id") Integer id,Hastalar hastalar){
        Hastalar updateHasta = hastalarService.getHastalarById(id).orElseThrow(()->new ExpressionException("HATA"));
        updateHasta.setHastaAdi(hastalar.getHastaAdi());
        updateHasta.setHastaSoyadi(hastalar.getHastaSoyadi());
        updateHasta.setHastaTC(hastalar.getHastaTC());
        updateHasta.setRaporTarih(hastalar.getRaporTarih());
        updateHasta.setTaniBasligi(hastalar.getTaniBasligi());
        updateHasta.setTaniDetaylari(hastalar.getTaniDetaylari());
        hastalarService.updateHastalar(updateHasta);
        return "redirect:/hastalar";
    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "password",required = false) Long password,
                        HttpSession session){
        User user = userService.findUserByUsernameAndPassword(username,password);
        if(user!=null){
            session.setAttribute("loggedInUser",user);
            // setUserSession
            // session ve cookie
            return "redirect:/hastalar";
        }
        else {
            return "redirect:/home?hata";
        }
    }
    @GetMapping("/")
    public String redirectHome(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(){

        return "home";
    }
}
