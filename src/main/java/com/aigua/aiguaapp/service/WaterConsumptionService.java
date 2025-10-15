package com.aigua.aiguaapp.service;

import com.aigua.aiguaapp.dto.SummaryDTO;
import com.aigua.aiguaapp.model.WaterConsumption;
import com.aigua.aiguaapp.repository.WaterConsumptionRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WaterConsumptionService {

    private final WaterConsumptionRepository repository;

    public WaterConsumptionService(WaterConsumptionRepository repository) {
        this.repository = repository;
    }

    public List<WaterConsumption> getAll() {
        return repository.findAll();
    }

    public List<SummaryDTO> calculateSummary() {
        List<WaterConsumption> all = repository.findAll();
        double totalCityLiters = all.stream().mapToDouble(WaterConsumption::getConsumptionLiters).sum();
        if (totalCityLiters == 0) totalCityLiters = 1.0; // avoid division by zero

        Map<String, List<WaterConsumption>> byNeighborhood = all.stream()
                .collect(Collectors.groupingBy(WaterConsumption::getNeighborhood));

        List<SummaryDTO> summaries = new ArrayList<>();

        for (Map.Entry<String, List<WaterConsumption>> entry : byNeighborhood.entrySet()) {
            String neighborhood = entry.getKey();
            List<WaterConsumption> list = entry.getValue();

            double total = list.stream().mapToDouble(WaterConsumption::getConsumptionLiters).sum();

            String mainUsageType = list.stream()
                    .collect(Collectors.groupingBy(WaterConsumption::getUsageType, Collectors.summingDouble(WaterConsumption::getConsumptionLiters)))
                    .entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse("unknown");

            double percentage = (total / totalCityLiters) * 100.0;

            summaries.add(new SummaryDTO(neighborhood, round(total), round(percentage), mainUsageType));
        }

        // sort descending by total liters for easier reading
        summaries.sort(Comparator.comparingDouble(SummaryDTO::getTotalLiters).reversed());
        return summaries;
    }

    private double round(double v) {
        return Math.round(v * 10.0) / 10.0;
    }
}
