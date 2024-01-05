package com.example.aminehamed.services;

import com.example.aminehamed.entities.Bus;
import com.example.aminehamed.entities.Role;
import com.example.aminehamed.entities.Trajet;
import com.example.aminehamed.entities.Utilisateur;
import com.example.aminehamed.repository.busRepositry;
import com.example.aminehamed.repository.utilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@Aspect
@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements IuserService {

    final utilisateurRepository utilisateurRepositorys ;
    final busRepositry busRepositrys;

    @Override
    public Utilisateur addStudent(Utilisateur utilisateur) {
        return utilisateurRepositorys.save(utilisateur);
    }

@Override
    @Transactional
    public String affecterEtudiantAbus(String numImma, String nom, String prenom) {

        Bus bus = busRepositrys.findByNumImmatriculation(numImma);

        if (bus != null) {

            Utilisateur student = utilisateurRepositorys.findByNomAndPrenom(nom, prenom);
            if (student == null) {
                student = new Utilisateur();
                student.setNom(nom);
                student.setPrenom(prenom);
                student.setRole(Role.ETUDIANT);
                utilisateurRepositorys.save(student);
            }


            student.setBus(bus);
            utilisateurRepositorys.save(student);

            return "Student " + nom + " " + prenom + " associated with Bus " + numImma + " successfully.";
        }

        return "Bus with number plate " + numImma + " not found.";
    }

}
