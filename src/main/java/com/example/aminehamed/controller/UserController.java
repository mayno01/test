package com.example.aminehamed.controller;

import com.example.aminehamed.entities.Utilisateur;
import com.example.aminehamed.services.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IuserService iuserService;

    @PostMapping("/add")
    public Utilisateur addStudent(@RequestBody Utilisateur utilisateur) {
        return iuserService.addStudent(utilisateur);
    }



    @PostMapping("/associate-student-bus")
    public ResponseEntity<String> associateStudentWithBus(
            @RequestParam String busNumberPlate,
            @RequestParam String studentName,
            @RequestParam String studentSurname
    ) {
        String resultMessage = iuserService.affecterEtudiantAbus(busNumberPlate, studentName, studentSurname);

        return ResponseEntity.ok(resultMessage);
    }


}
