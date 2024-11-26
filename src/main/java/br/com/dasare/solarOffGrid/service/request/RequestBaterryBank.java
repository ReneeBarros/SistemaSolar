package br.com.dasare.solarOffGrid.service.request;

public record RequestBaterryBank(

    Double totalPowerSistemPerDay,
    Integer autonomyDay,
    Integer voltagyBatteryBank,
    Double dischargeDepthOfBatteryBank,
    Integer voltagyInInversor,
    Integer voltagyBattery,
    Integer capacityBateryAH

) { }
