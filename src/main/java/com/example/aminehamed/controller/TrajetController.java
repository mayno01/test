package com.example.aminehamed.controller;

import com.example.aminehamed.entities.Trajet;
import com.example.aminehamed.services.ItrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trajet")
public class TrajetController {

    @Autowired
    private ItrajetService itrajetService;


    @PostMapping("/add")
    public Trajet addTrajet(@RequestBody Trajet trajet) {
        return itrajetService.addTrajet(trajet);
    }
}
