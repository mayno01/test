package com.example.aminehamed.services;

import com.example.aminehamed.entities.Bus;
import com.example.aminehamed.entities.Role;
import com.example.aminehamed.entities.Trajet;
import com.example.aminehamed.entities.Utilisateur;
import com.example.aminehamed.repository.busRepositry;
import com.example.aminehamed.repository.trajetRepository;
import com.example.aminehamed.repository.utilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
@Aspect
@Service
@RequiredArgsConstructor
public class BusServiceImpl implements IbusServices {

    final busRepositry busRepositrys;
    final utilisateurRepository  utilisateurRepositorys;
    final trajetRepository trajetRepositorys;
    @Override
    @Transactional
    public Bus ajouterBusEtChauffeur(Bus bus, Utilisateur chauffeur) {

        chauffeur.setRole(Role.chauffeur);


        chauffeur.setBus(bus);
        bus.setChauffeur(chauffeur);

        busRepositrys.save(bus);


        utilisateurRepositorys.save(chauffeur);

        return bus;
    }
    @Override
    @Transactional
    public Bus affecterTrajetABus(int idBus, int idTrajet) {
        Bus bus = busRepositrys.findById(idBus).orElse(null);
        Trajet trajet = trajetRepositorys.findById(idTrajet).orElse(null);

        if (bus != null && trajet != null) {
            bus.setTrajet(trajet);
            busRepositrys.save(bus);
        }

        return bus;
    }


}
