package com.example.aminehamed.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "trajet")
public class Trajet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrajet;
    private String pointDepart;

    @JsonIgnoreProperties("trajet")
    @OneToMany(cascade = CascadeType.ALL, mappedBy="trajet")
    private Set<Bus> Buses;

}
