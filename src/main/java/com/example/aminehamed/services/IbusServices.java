package com.example.aminehamed.services;

import com.example.aminehamed.entities.Bus;
import com.example.aminehamed.entities.Utilisateur;

public interface IbusServices {
    public Bus ajouterBusEtChauffeur(Bus bus, Utilisateur chauffeur);
    Bus affecterTrajetABus ( int idBus , int idTrajet);
}
