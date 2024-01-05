package com.example.aminehamed.services;

import com.example.aminehamed.entities.Utilisateur;

import java.time.LocalDate;
import java.util.List;

public interface IuserService {

    public Utilisateur addStudent(Utilisateur utilisateur);
    public String affecterEtudiantAbus(String numImma, String nom, String prenom);

}
