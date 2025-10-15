package com.aigua.aiguaapp.dto;

public class SummaryDTO {
    private String neighborhood;
    private double totalLiters;
    private double percentageOfCity;
    private String mainUsageType;

    public SummaryDTO() {}

    public SummaryDTO(String neighborhood, double totalLiters, double percentageOfCity, String mainUsageType) {
        this.neighborhood = neighborhood;
        this.totalLiters = totalLiters;
        this.percentageOfCity = percentageOfCity;
        this.mainUsageType = mainUsageType;
    }

    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    public double getTotalLiters() { return totalLiters; }
    public void setTotalLiters(double totalLiters) { this.totalLiters = totalLiters; }

    public double getPercentageOfCity() { return percentageOfCity; }
    public void setPercentageOfCity(double percentageOfCity) { this.percentageOfCity = percentageOfCity; }

    public String getMainUsageType() { return mainUsageType; }
    public void setMainUsageType(String mainUsageType) { this.mainUsageType = mainUsageType; }
}
