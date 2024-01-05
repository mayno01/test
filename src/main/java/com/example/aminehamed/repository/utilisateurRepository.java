package com.example.aminehamed.repository;

import com.example.aminehamed.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface utilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Utilisateur findByNomAndPrenom(String nom, String prenom);


}
