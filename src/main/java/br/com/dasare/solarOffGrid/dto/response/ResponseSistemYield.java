package br.com.dasare.solarOffGrid.dto.response;

public record ResponseSistemYield(
        String city,
        Double priceKWh,
        Double initialInvestiment,
        Double sistemPowerGeneration,
        Double monthlyEnergyConsumption,
        Double sistemEfficiency,
        Double annualMaintaenanceCost,
        Double annualAdjsutment,
        Integer years,
        Double solarIrradiance,
        Double dailyEnergyProduction,
        Double monthlyEnergyProduction,
        Double yearlyEnergyProduction,
        Double monthlyServicePercentage,
        Double monthlySavings,
        Double yearlySavings,
        Double roiInMonths,
        Double multipleReturn,
        Double cumulativeSavingsInYears,
        Double dailyCo2Reduction,
        Double monthlyCo2Reduction,
        Double yearlyCo2Reduciton

) {

}
