package br.com.dasare.solarOffGrid.service.calculatesystemload.systemload;

import br.com.dasare.solarOffGrid.domain.offgrid.interfac.OffGridCalculateInterface;
import br.com.dasare.solarOffGrid.dto.request.RequestOffGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemLoad;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CalculateSistemLoad {

   private final OffGridCalculateInterface offgrid;


    CalculateSistemLoad(
        OffGridCalculateInterface offgrid
    ){
        this.offgrid = offgrid;

    }


    public ResponseSistemLoad caculateSistemLoad( RequestOffGrid request){

        Double inversorEficient = 0.90;

        List<Double> listLoad = offgrid.load(request);
        List<Double> listConsumptionEquipmentPerDay = offgrid.consumptionEquipmentPerDay(listLoad,request);
        Double totalLoad = Double.valueOf(String.format("%.2f", offgrid.totalLoad(listLoad)).replace(",","."));
        Double totalConsumptionEquipmentPerDay = Double.valueOf(String.format("%.2f", offgrid.totalConsumptionEquipmentPerDay(listConsumptionEquipmentPerDay)).replace(",","."));
        Double correctedEnergyDay = Double.valueOf(String.format("%.2f", offgrid.correctedEnergyDay(inversorEficient, (Double) totalConsumptionEquipmentPerDay)).replace(",","."));
        Double geralenergyRequired = Double.valueOf(String.format("%.2f", offgrid.GeralenergyRequired(correctedEnergyDay)).replace(",",".")) ;
        Double mininuinvesorPower = Double.valueOf(String.format("%.2f", offgrid.MininuinvesorPower(totalLoad)).replace(",","."));
        Double maxinvesorPower = Double.valueOf(String.format("%.2f", offgrid.MaxinvesorPower(totalLoad)).replace(",","."));

        return new ResponseSistemLoad(
                 listLoad,
            listConsumptionEquipmentPerDay,
            totalLoad,
            totalConsumptionEquipmentPerDay,
            correctedEnergyDay,
            geralenergyRequired,
            mininuinvesorPower,
            maxinvesorPower
        ) ;

    }

}
