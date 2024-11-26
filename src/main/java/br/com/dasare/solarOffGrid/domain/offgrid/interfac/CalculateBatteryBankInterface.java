package br.com.dasare.solarOffGrid.domain.offgrid.interfac;

public interface CalculateBatteryBankInterface {

    Integer BatteryBankCapacityUseful(Double totalPowerSistemPerDay, Integer autonomyDay, Integer voltagyBatteryBank);
    Integer batteryBankCapacityReal(Integer batteryBankCapacityUseful, Double dischargeDepthOfBatteryBank);
    Integer numberOfBatteriesInsires(Integer voltagyInInversor, Integer voltagyBattery);
    Integer numberOfBatteriesParallel(Integer batteryBankCapacityReal, Integer capacityBateryAH);
    Integer numberTotalOfBattty(Integer numberOfBatteriesInsires, Integer numberOfBatteriesParallel );

}
