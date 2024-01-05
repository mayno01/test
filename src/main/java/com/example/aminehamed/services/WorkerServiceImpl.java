package com.example.aminehamed.services;


import com.example.aminehamed.entities.*;
import com.example.aminehamed.repository.ReservationR;
import com.example.aminehamed.repository.VehicleR;
import com.example.aminehamed.repository.Washing_serviceR;
import com.example.aminehamed.repository.WorkerR;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EnableAspectJAutoProxy
@Slf4j
@Component
@Aspect
@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerS{

    final ReservationR reservationR;
    final VehicleR vehicleR;
    final Washing_serviceR washingServiceR;
    final WorkerR workerR;

    @Override
    public Worker addWorker ( Worker worker){
       return workerR.save(worker);
    }

    @Override
    public void addWashingService(List<Washing_Service> washing_service){
        washingServiceR.saveAll(washing_service);


    }

    @Override
    @Transactional
    public Vehicle addVehicleReservationAndAffectToWashingService(Vehicle vehicle, List<Long> idServices) {
        Reservation reservation = new Reservation();
        reservation.setTimeReservation(LocalDate.now());
        reservation.setStatus(Status.PENDING);

        Set<Washing_Service> washingServices = new HashSet<>();
        for (Long idService : idServices) {
            Washing_Service washingService = washingServiceR.findById(idService).orElse(null);
            if (washingService != null) {
                washingServices.add(washingService);
            }
        }

        reservation.setWashingServices(washingServices);


        Set<Reservation> reservations = vehicle.getReservations();
        if (reservations == null) {
            reservations = new HashSet<>();
        }
        reservations.add(reservation);
        vehicle.setReservations(reservations);


        Vehicle savedVehicle = vehicleR.save(vehicle);

        return savedVehicle;
    }

    @Override
    @Transactional
    public Worker affectWorkertoReservation(String nic, List<Long> idReservation) {
        Worker worker = workerR.findByNic(nic);
        if (worker == null) {

            return null;
        }

        Set<Reservation> reservations = worker.getReservations();
        int numReservations = reservations.size();

        if (numReservations + idReservation.size() > 5) {

            return null;
        }

        for (Long reservationId : idReservation) {
            Reservation reservation = reservationR.findById(reservationId).orElse(null);

            if (reservation != null) {
                reservation.setStatus(Status.CONFIRMED);
                reservation.setWorker(worker);
                reservations.add(reservation);
            }
        }

        worker.setReservations(reservations);
        workerR.save(worker);

        return worker;
    }
}
