package com.example.aminehamed.entities;

import jakarta.persistence.Entity;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusChauffeurDTO {
    private Bus bus;
    private Utilisateur utilisateur;
}
