package com.example.aminehamed.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "bus")
public class Bus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBus;
    private String numImmatriculation;
    private Date dateMiseEnService;
    private int nbreDePlaceMax;
    @JsonIgnoreProperties("bus")
    @ManyToOne
    @JoinColumn(name = "idTrajet")
 Trajet trajet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="bus")
    private Set<Utilisateur> Utilisateures;

    @OneToOne
    private Utilisateur chauffeur;

}
