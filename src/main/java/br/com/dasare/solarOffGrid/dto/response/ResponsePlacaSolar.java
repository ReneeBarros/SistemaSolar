package br.com.dasare.solarOffGrid.dto.response;

public record ResponsePlacaSolar(
        Long Id,
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

