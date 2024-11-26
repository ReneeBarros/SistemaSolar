package br.com.dasare.solarOffGrid.domain.offgrid.impl;

import br.com.dasare.solarOffGrid.domain.offgrid.interfac.OffGridCalculateInterface;
import br.com.dasare.solarOffGrid.service.request.RequestOffGrid;

import java.util.List;
import java.util.Optional;

public class OffGridCalculateImpl implements OffGridCalculateInterface {
    @Override
    public List<Double> load(RequestOffGrid requestOffGrid) {

        List<Double> listOfLoad = new java.util.ArrayList<>(List.of());
        requestOffGrid.equipments().forEach(
            item-> listOfLoad.add(
                    (item.equipmentPower() * item.quantityEquipment())
            )
        );
        return listOfLoad;
    }

    @Override
    public List<Double> consumptionEquipmentPerDay(List<Double> load, RequestOffGrid requestOffGrid) {
        List<Double> consumptionEquipmentPerDay = new java.util.ArrayList<>(List.of());
        for (int i = 0; i <load.size() ; i++) {

            consumptionEquipmentPerDay.add( (load.get(i) * requestOffGrid.equipments().get(i).hoursDailyUse()) );
        }
        return consumptionEquipmentPerDay;
    }

    @Override
    public Double totalLoad(List<Double> load) {
        Optional<Double> totalLoadResult = load.stream().reduce(Double::sum);
        return totalLoadResult.get();
    }

    @Override
    public Double totalConsumptionEquipmentPerDay(List<Double> consumptionEquipmentPerDay) {
        Optional<Double> totalwatthours = consumptionEquipmentPerDay.stream().reduce(Double::sum);
        return totalwatthours.get();
    }

    @Override
    public Double MininuinvesorPower(Double inversor) {
        return inversor * 1.43 ;
    }

    @Override
    public Double MaxinvesorPower(Double inversor) {
        return inversor * 2.0;
    }

    @Override
    public Double correctedEnergyDay(Double inversorEficient, Double totalConsumptionEquipmentPerDay ) {
        return (totalConsumptionEquipmentPerDay / inversorEficient);
    }

    @Override
    public Double GeralenergyRequired(Double globalRediment, Double correctedEnergyDay) {
        return (correctedEnergyDay / globalRediment);
    }

}
