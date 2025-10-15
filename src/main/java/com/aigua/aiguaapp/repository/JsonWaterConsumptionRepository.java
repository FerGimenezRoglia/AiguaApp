package com.aigua.aiguaapp.repository;

import com.aigua.aiguaapp.model.WaterConsumption;
import com.aigua.aiguaapp.util.JsonDataLoader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JsonWaterConsumptionRepository implements WaterConsumptionRepository {

    private final JsonDataLoader loader = new JsonDataLoader();
    private static final String RESOURCE = "consumption.json";

    @Override
    public List<WaterConsumption> findAll() {
        // Reads from JSON on each call to reflect file changes quickly
        return loader.readList(RESOURCE, WaterConsumption[].class);
    }
}
