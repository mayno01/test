package com.example.aminehamed.controller;

import com.example.aminehamed.entities.Bus;
import com.example.aminehamed.entities.BusChauffeurDTO;
import com.example.aminehamed.entities.Trajet;
import com.example.aminehamed.entities.Utilisateur;
import com.example.aminehamed.repository.utilisateurRepository;
import com.example.aminehamed.services.IbusServices;
import com.example.aminehamed.services.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private IbusServices ibusServices;
    @Autowired
    private utilisateurRepository utilisateurRepositorys;

    @PostMapping("/add")
    public Bus addBusEtChauffeur(@RequestBody BusChauffeurDTO busChauffeurDTO) {
        Bus bus = busChauffeurDTO.getBus();
        Utilisateur utilisateur = busChauffeurDTO.getUtilisateur();
        utilisateurRepositorys.save(utilisateur);
        bus.setChauffeur(utilisateur);
        return ibusServices.ajouterBusEtChauffeur(bus, utilisateur);
    }


    @PutMapping("/affecter/{idBus}/{idTrajet}")
    public  Bus affectertrajetetbus (@PathVariable int idBus , @PathVariable int idTrajet){
        return ibusServices.affecterTrajetABus(idBus,idTrajet);
    }
}
