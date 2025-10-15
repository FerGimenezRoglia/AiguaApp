package com.aigua.aiguaapp.repository;

import com.aigua.aiguaapp.model.WaterConsumption;
import java.util.List;

public interface WaterConsumptionRepository {
    List<WaterConsumption> findAll();
}
