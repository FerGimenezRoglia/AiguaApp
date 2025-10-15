package com.aigua.aiguaapp.service;

import com.aigua.aiguaapp.model.Anomaly;
import com.aigua.aiguaapp.repository.AnomalyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyService {

    private final AnomalyRepository repository;

    public AnomalyService(AnomalyRepository repository) {
        this.repository = repository;
    }

    public List<Anomaly> getAll() {
        return repository.findAll();
    }
}
