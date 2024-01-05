package com.example.aminehamed.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVehicle;
    private String brand;
    private String immatriculation;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
