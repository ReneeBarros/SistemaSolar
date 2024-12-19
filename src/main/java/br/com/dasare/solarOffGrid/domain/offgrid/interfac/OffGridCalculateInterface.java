package br.com.dasare.solarOffGrid.domain.offgrid.interfac;


import br.com.dasare.solarOffGrid.dto.request.RequestOffGrid;

import java.util.List;

public interface OffGridCalculateInterface {

    List<Double> load(RequestOffGrid requestOffGrid);

    List<Double> consumptionEquipmentPerDay(List<Double> load, RequestOffGrid requestOffGrid);

    Double totalLoad(List<Double> load);
    Double totalConsumptionEquipmentPerDay(List<Double> consumptionEquipmentPerDay);

    Double MininuinvesorPower(Double inversor);

    Double MaxinvesorPower(Double inversor);

    Double correctedEnergyDay(Double inversorEficient, Double totalConsumptionEquipmentPerDay);

    Double GeralenergyRequired( Double correctedEnergyDay);

}
