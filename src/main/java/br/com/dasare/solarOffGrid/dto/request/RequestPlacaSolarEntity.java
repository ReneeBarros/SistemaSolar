package br.com.dasare.solarOffGrid.dto.request;

public record RequestPlacaSolarEntity(

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
