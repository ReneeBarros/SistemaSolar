package br.com.dasare.solarOffGrid.service.calculatebattery.battery;


import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateBatteryBankInterface;
import br.com.dasare.solarOffGrid.service.request.RequestBaterryBank;
import br.com.dasare.solarOffGrid.service.response.ResponseBaterryBank;
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
        Integer nbs = baterry.numberOfBatteriesInsires(request.voltagyInInversor(), request.voltagyBattery());
        Integer nbp = baterry.numberOfBatteriesParallel(bbcr, request.capacityBateryAH());
        Integer ntb = baterry.numberTotalOfBattty(nbs,nbp);
        return new ResponseBaterryBank(
                bbcu,bbcr,nbs,nbp,ntb
        );
    }

}
