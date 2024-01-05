package com.example.aminehamed.services;

import com.example.aminehamed.entities.Reservation;
import com.example.aminehamed.entities.Status;
import com.example.aminehamed.repository.ReservationR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationScheduler {

    @Autowired
    private ReservationR reservationRepository;


}