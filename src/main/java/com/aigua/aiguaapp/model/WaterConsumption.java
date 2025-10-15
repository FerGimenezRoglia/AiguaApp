package com.aigua.aiguaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class WaterConsumption {
    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("date_time")
    private LocalDateTime dateTime;

    @JsonProperty("consumption_liters")
    private double consumptionLiters;

    @JsonProperty("usage_type")
    private String usageType; // "domestic" | "industrial"

    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public double getConsumptionLiters() { return consumptionLiters; }
    public void setConsumptionLiters(double consumptionLiters) { this.consumptionLiters = consumptionLiters; }

    public String getUsageType() { return usageType; }
    public void setUsageType(String usageType) { this.usageType = usageType; }
}
