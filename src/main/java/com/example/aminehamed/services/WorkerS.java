package com.example.aminehamed.services;

import com.example.aminehamed.entities.Vehicle;
import com.example.aminehamed.entities.Washing_Service;
import com.example.aminehamed.entities.Worker;

import java.util.List;

public interface WorkerS {
    public Worker addWorker (Worker worker);
    public void addWashingService(List<Washing_Service> washing_service);
    public Vehicle addVehicleReservationAndAffectToWashingService(Vehicle vehicle , List<Long> idService);
    public Worker affectWorkertoReservation(String nic, List<Long> idReservation);
}
