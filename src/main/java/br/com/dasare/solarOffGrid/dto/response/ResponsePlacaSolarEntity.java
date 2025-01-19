package br.com.dasare.solarOffGrid.dto.response;

public record ResponsePlacaSolarEntity(
        Long Id,
        String marcaSolarPainel,
        Double pvModuleEfficienty,
        String pvType,
        Double openCircuitVoltage,
        Double optimumOperatingVoltageVmp,
        Double shortCircuitCurrentIsc,
        Double optimumOperatingCurrentImp,
        Double maximumPoweratSTCpmax,
        String operatingTemperature,
        String nominalOperatingCellTemperature,
        Double tempCoefficientofPmax,
        Double tempCoefficientofVoc,
        Double tempCoefficientofIsc
) {
}

