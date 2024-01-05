package com.example.aminehamed.repository;

import com.example.aminehamed.entities.Reservation;
import com.example.aminehamed.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationR extends JpaRepository<Reservation,Long> {

}
