package br.com.dasare.solarOffGrid.service.calculatebattery.battery;


import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateBatteryBankInterface;
import br.com.dasare.solarOffGrid.dto.request.RequestBaterryBank;
import br.com.dasare.solarOffGrid.dto.response.ResponseBaterryBank;
import org.springframework.stereotype.Service;

@Service
public class CalculateBaterryBank {

    private final CalculateBatteryBankInterface baterry;

    public CalculateBaterryBank(CalculateBatteryBankInterface baterry) {
        this.baterry = baterry;
    }


    public ResponseBaterryBank baterryBank(RequestBaterryBank request){
        Integer bbcu = baterry.BatteryBankCapacityUseful(request.totalPowerSistemPerDay(), request.autonomyDay(), request.voltagyBatteryBank());
        Integer bbcr = baterry.batteryBankCapacityReal(bbcu, request.dischargeDepthOfBatteryBank());
        Integer nbs = baterry.numberOfBatteriesInsires(request.voltagyBatteryBank(), request.voltagyBattery());
        double nbp = Math.ceil(baterry.numberOfBatteriesParallel(bbcr, request.capacityBateryAH()));
        double ntb = Math.ceil(baterry.numberTotalOfBattty(nbs,nbp));
        return new ResponseBaterryBank(
                bbcu,bbcr,nbs,nbp,ntb
        );
    }

}
