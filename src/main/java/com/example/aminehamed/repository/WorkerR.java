package com.example.aminehamed.repository;

import com.example.aminehamed.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerR extends JpaRepository<Worker,Long> {
    Worker findByNic (String nic);
}
