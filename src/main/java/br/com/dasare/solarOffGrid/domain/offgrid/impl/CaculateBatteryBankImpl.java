package br.com.dasare.solarOffGrid.domain.offgrid.impl;

import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateBatteryBankInterface;

public class CaculateBatteryBankImpl implements CalculateBatteryBankInterface {
    @Override
    public Integer BatteryBankCapacityUseful(
            Double totalPowerSistemPerDay,
            Integer autonomyDay,
            Integer voltagyBatteryBank
    ) {
        return (int) ((totalPowerSistemPerDay * autonomyDay)/voltagyBatteryBank);
    }

    @Override
    public Integer batteryBankCapacityReal(
            Integer batteryBankCapacityUseful,
            Double dischargeDepthOfBatteryBank
    ) {
        return (int) (batteryBankCapacityUseful / dischargeDepthOfBatteryBank);
    }

    @Override
    public Integer numberOfBatteriesInsires(
            Integer voltagyInInversor,
            Integer voltagyBattery
    ) {
        return (voltagyInInversor / voltagyBattery);
    }

    @Override
    public Integer numberOfBatteriesParallel(Integer batteryBankCapacityReal, Integer capacityBateryAH) {
        return (batteryBankCapacityReal / capacityBateryAH);
    }

    @Override
    public Integer numberTotalOfBattty(Integer numberOfBatteriesInsires, Integer numberOfBatteriesParallel) {
        return (numberOfBatteriesInsires * numberOfBatteriesParallel);
    }
}
