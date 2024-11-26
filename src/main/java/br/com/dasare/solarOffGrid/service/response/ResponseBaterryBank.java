package br.com.dasare.solarOffGrid.service.response;

public record ResponseBaterryBank(

        Integer BatteryBankCapacityUseful,
        Integer batteryBankCapacityReal,
        Integer numberOfBatteriesInsires,
        Integer numberOfBatteriesParallel,
        Integer numberTotalOfBattty
) { }
