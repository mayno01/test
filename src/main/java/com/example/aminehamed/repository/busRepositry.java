package com.example.aminehamed.repository;

import com.example.aminehamed.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface busRepositry extends JpaRepository<Bus,Integer> {

    Bus findByNumImmatriculation(String numImmatriculation);
}
