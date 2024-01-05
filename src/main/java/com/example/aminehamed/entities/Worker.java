package com.example.aminehamed.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAgent;
    private String nom;
    private String nic;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="worker")
    private Set<Reservation> reservations;

}
