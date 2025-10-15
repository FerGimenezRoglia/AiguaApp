package com.aigua.aiguaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class Anomaly {
    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("date_time")
    private LocalDateTime dateTime;

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;

    @JsonProperty("consumption_liters")
    private double consumptionLiters;

    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public double getConsumptionLiters() { return consumptionLiters; }
    public void setConsumptionLiters(double consumptionLiters) { this.consumptionLiters = consumptionLiters; }
}
