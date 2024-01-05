package com.example.aminehamed.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;
    private String nom;
    private String prenom;
    private Date dateDebutAbonnement;
    private Date dateFinAbonnement;
    @Enumerated(EnumType.STRING)
    private Role role;
    @JsonIgnoreProperties("utilisateur")
    @ManyToOne
    Bus bus;
}

