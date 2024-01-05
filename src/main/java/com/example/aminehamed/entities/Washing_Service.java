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
@Table(name = "washing_Service")
public class Washing_Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idService;
    private float price;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy="washingServices", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
