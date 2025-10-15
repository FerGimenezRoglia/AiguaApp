package com.aigua.aiguaapp.repository;

import com.aigua.aiguaapp.model.Anomaly;
import java.util.List;

public interface AnomalyRepository {
    List<Anomaly> findAll();
}
