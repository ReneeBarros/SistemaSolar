package br.com.dasare.solarOffGrid.dto.response;

public record ResponseBaterryBank(

        Integer BatteryBankCapacityUseful,
        Integer batteryBankCapacityReal,
        Integer numberOfBatteriesInsires,
        Double numberOfBatteriesParallel,
        Double numberTotalOfBattty
) { }
