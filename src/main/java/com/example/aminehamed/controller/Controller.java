package com.example.aminehamed.controller;


import com.example.aminehamed.entities.Vehicle;
import com.example.aminehamed.entities.Washing_Service;
import com.example.aminehamed.entities.Worker;
import com.example.aminehamed.services.WorkerS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projet")
public class Controller {
    @Autowired
    private WorkerS workerS;

    @PostMapping("addworker")
    public Worker addWorker (@RequestBody  Worker worker){
        return workerS.addWorker(worker);


    }

    @PostMapping("addwashing")
    public void addWashingService(@RequestBody  List<Washing_Service> washing_service){
        workerS.addWashingService(washing_service);
    }
    @PostMapping("V/{idServices}")
    public Vehicle addVehicleReservationAndAffectToWashingService(@RequestBody Vehicle vehicle, @PathVariable("idServices") List<Long> idServices){
     return   workerS.addVehicleReservationAndAffectToWashingService(vehicle,idServices);
    }
    @PutMapping("up/{nic}")
    public Worker affectWorkertoReservation(@PathVariable("nic") String nic, @RequestBody  List<Long> idReservation){
       return workerS.affectWorkertoReservation(nic,idReservation);
    }

}
