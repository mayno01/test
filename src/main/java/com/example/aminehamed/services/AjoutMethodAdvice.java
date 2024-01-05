package com.example.aminehamed.services;

import com.example.aminehamed.entities.Trajet;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AjoutMethodAdvice {

    @AfterReturning("execution(* com.example.aminehamed.services.WorkerServiceImpl.addVehicleReservationAndAffectToWashingService(..))")
    public void logAfterAddMethod() {
        System.out.println("Waiting for a worker...");
    }


}
