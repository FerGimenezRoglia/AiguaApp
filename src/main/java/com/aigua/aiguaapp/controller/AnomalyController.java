package com.aigua.aiguaapp.controller;

import com.aigua.aiguaapp.model.Anomaly;
import com.aigua.aiguaapp.service.AnomalyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/anomalies")
public class AnomalyController {

    private final AnomalyService service;

    public AnomalyController(AnomalyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Anomaly> getAll() {
        return service.getAll();
    }
}
