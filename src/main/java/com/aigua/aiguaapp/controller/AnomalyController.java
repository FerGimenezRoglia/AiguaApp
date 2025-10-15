package com.aigua.aiguaapp.controller;

import com.aigua.aiguaapp.model.Anomaly;
import com.aigua.aiguaapp.service.AnomalyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/anomalies")
@Tag(name = "Anomalies", description = "Endpoints for detecting anomalies in water consumption")
public class AnomalyController {

    private final AnomalyService service;

    public AnomalyController(AnomalyService service) {
        this.service = service;
    }

    @Operation(summary = "Get all anomalies detected in water usage")
    @ApiResponse(responseCode = "200", description = "List of anomaly records")
    @GetMapping
    public List<Anomaly> getAll() {
        return service.getAll();
    }
}
