package com.aigua.aiguaapp.controller;

import com.aigua.aiguaapp.dto.SummaryDTO;
import com.aigua.aiguaapp.model.WaterConsumption;
import com.aigua.aiguaapp.service.WaterConsumptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consumption")
public class WaterConsumptionController {

    private final WaterConsumptionService service;

    public WaterConsumptionController(WaterConsumptionService service) {
        this.service = service;
    }

    @GetMapping
    public List<WaterConsumption> getAll() {
        return service.getAll();
    }

    @GetMapping("/summary")
    public List<SummaryDTO> getSummary() {
        return service.calculateSummary();
    }
}
