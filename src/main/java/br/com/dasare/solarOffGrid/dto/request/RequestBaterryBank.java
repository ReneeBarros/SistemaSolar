package br.com.dasare.solarOffGrid.dto.request;

public record RequestBaterryBank(

    Double totalPowerSistemPerDay,
    Double autonomyDay,
    Integer voltagyBatteryBank,
    Double dischargeDepthOfBatteryBank,
    Integer voltagyInInversor,
    Integer voltagyBattery,
    Integer capacityBateryAH

) { }
