package br.com.dasare.solarOffGrid.dto.request;

public record RequestPlacaSolar(

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
