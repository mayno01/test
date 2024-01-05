package com.example.aminehamed.services;

import com.example.aminehamed.entities.Trajet;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AjoutMethodAdvice {

    @AfterReturning("execution(* com.example.aminehamed.services.trajetServiceImpl.addTrajet(com.example.aminehamed.entities.Trajet))")

    public void logAfterAddMethod() {
        System.out.println("c'est une méthode d'ajout");
    }
    @AfterReturning("execution(* com.example.aminehamed.services.IuserService.addStudent(com.example.aminehamed.entities.Utilisateur))")
    public void logAfterAddStudent() {
        System.out.println("c'est une méthode d'ajout d'étudiant");
    }


}
