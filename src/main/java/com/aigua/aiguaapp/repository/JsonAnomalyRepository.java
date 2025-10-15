package com.aigua.aiguaapp.repository;

import com.aigua.aiguaapp.model.Anomaly;
import com.aigua.aiguaapp.util.JsonDataLoader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JsonAnomalyRepository implements AnomalyRepository {

    private final JsonDataLoader loader = new JsonDataLoader();
    private static final String RESOURCE = "anomalies.json";

    @Override
    public List<Anomaly> findAll() {
        // Reads from JSON on each call to reflect file changes quickly
        return loader.readList(RESOURCE, Anomaly[].class);
    }
}
