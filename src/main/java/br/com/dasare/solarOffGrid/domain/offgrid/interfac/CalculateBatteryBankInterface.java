package br.com.dasare.solarOffGrid.domain.offgrid.interfac;

public interface CalculateBatteryBankInterface {

    Integer BatteryBankCapacityUseful(Double totalPowerSistemPerDay, Double autonomyDay, Integer voltagyBatteryBank);
    Integer batteryBankCapacityReal(Integer batteryBankCapacityUseful, Double dischargeDepthOfBatteryBank);
    Integer numberOfBatteriesInsires(Integer voltagyInInversor, Integer voltagyBattery);
    double numberOfBatteriesParallel(Integer batteryBankCapacityReal, Double capacityBateryAH);
    double numberTotalOfBattty(Integer numberOfBatteriesInsires, double numberOfBatteriesParallel );

}
