package br.com.dasare.solarOffGrid.dto.request;

public record RequestSolarSistemYield(

        String city,
        Double sistemPowerGeneration,
        Double monthlyEnergyConsumption,
        Double sistemEfficiency,
        Double priceKWh,
        Double initialInvestiment,
        Double annualMaintaenanceCost,
        Double annualAdjsutmentTarifaEnergy,
        Integer years

) {
}
