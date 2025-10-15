package com.aigua.aiguaapp.controller;

import com.aigua.aiguaapp.dto.SummaryDTO;
import com.aigua.aiguaapp.model.WaterConsumption;
import com.aigua.aiguaapp.service.WaterConsumptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/consumption")
@Tag(name = "Water Consumption", description = "Endpoints for water consumption data")
public class WaterConsumptionController {

    private final WaterConsumptionService service;

    public WaterConsumptionController(WaterConsumptionService service) {
        this.service = service;
    }

    @Operation(summary = "Get all water consumption records")
    @ApiResponse(responseCode = "200", description = "List of water consumption records")
    @GetMapping
    public List<WaterConsumption> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Get water consumption summary by neighborhood")
    @ApiResponse(responseCode = "200", description = "Summary of water consumption by area")
    @GetMapping("/summary")
    public List<SummaryDTO> getSummary() {
        return service.calculateSummary();
    }
}
