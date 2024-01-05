package com.example.aminehamed.repository;

import com.example.aminehamed.entities.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface trajetRepository extends JpaRepository<Trajet,Integer> {

}
