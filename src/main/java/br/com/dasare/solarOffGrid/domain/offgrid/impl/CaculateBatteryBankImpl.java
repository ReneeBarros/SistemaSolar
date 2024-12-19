package br.com.dasare.solarOffGrid.domain.offgrid.impl;

import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateBatteryBankInterface;

public class CaculateBatteryBankImpl implements CalculateBatteryBankInterface {
    @Override
    // dimenciona o banco de bateria baseado na potencia total hora dia do sistema wh/dia total do sistema
    public Integer BatteryBankCapacityUseful(
            Double totalPowerSistemPerDay,  // Wh/dia total do sistema
            Double autonomyDay,
            Integer voltagyBatteryBank
    ) {

        return (int) (Math.round((totalPowerSistemPerDay * autonomyDay)/voltagyBatteryBank));
    }

    @Override
    // corrigi a capacidade real do banco de bateria, baseado na profundidade de descarga do banco de bateria
    public Integer batteryBankCapacityReal(
            Integer batteryBankCapacityUseful,
            Double dischargeDepthOfBatteryBank
    ) {
        return (int) (Math.round(batteryBankCapacityUseful / dischargeDepthOfBatteryBank));
    }

    @Override
    // dimenciona o numero de bateria em series
    public Integer numberOfBatteriesInsires(
            Integer voltagyInInversor,
            Integer voltagyBattery
    ) {
        return (voltagyInInversor / voltagyBattery);
    }

    @Override
    // dimenciona o numero de bateria em paralelo
    // essa capacidade da bateria em amper horas deve ser baseado na capacidade de 20hs de descarga da bateria ( 20hors mais proximo de 24 hs de um dia)
    public Integer numberOfBatteriesParallel(Integer batteryBankCapacityReal, Integer capacityBateryAH) {
        return (batteryBankCapacityReal / capacityBateryAH);
    }

    @Override
    // dimenciona o numero total de bateria para montagem do banco de bateria
    public Integer numberTotalOfBattty(Integer numberOfBatteriesInsires, Integer numberOfBatteriesParallel) {
        return (numberOfBatteriesInsires * numberOfBatteriesParallel);
    }
}
