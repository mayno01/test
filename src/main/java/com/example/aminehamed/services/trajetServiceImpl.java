package com.example.aminehamed.services;

import com.example.aminehamed.entities.Trajet;
import com.example.aminehamed.entities.Utilisateur;
import com.example.aminehamed.repository.trajetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class trajetServiceImpl implements ItrajetService {
    final  trajetRepository trajetRepositorys ;


    @Override
    public Trajet addTrajet(Trajet trajet) {
        return trajetRepositorys.save(trajet);
    }



}
