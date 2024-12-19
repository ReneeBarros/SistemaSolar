package br.com.dasare.solarOffGrid.domain.offgrid.impl;

import br.com.dasare.solarOffGrid.domain.offgrid.interfac.OffGridCalculateInterface;
import br.com.dasare.solarOffGrid.dto.request.RequestOffGrid;

import java.util.List;
import java.util.Optional;

public class OffGridCalculateImpl implements OffGridCalculateInterface {

    @Override
    // funcao que solicita uma lista de carga do ambiente a ser calculado
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
    // essa funcao pega todas as cargas e multiplica pelas horas de trabalho e gera uma lista de Wh/dia por equipamento
    public List<Double> consumptionEquipmentPerDay(List<Double> load, RequestOffGrid requestOffGrid) {
        List<Double> consumptionEquipmentPerDay = new java.util.ArrayList<>(List.of());
        for (int i = 0; i <load.size() ; i++) {

            consumptionEquipmentPerDay.add( (load.get(i) * requestOffGrid.equipments().get(i).hoursDailyUse()) );
        }
        return consumptionEquipmentPerDay;
    }

    @Override
    // gera o calculo total da carga instalada multiplicando todas as cargas fornecidas pelo cliente
    public Double totalLoad(List<Double> load) {
        Optional<Double> totalLoadResult = load.stream().reduce(Double::sum);
        return totalLoadResult.get();
    }

    @Override
    // gera o calculo total da carga consumida por dia em Wh/dia multiplicando todas as cargas utilizada no dia
    public Double totalConsumptionEquipmentPerDay(List<Double> consumptionEquipmentPerDay) {
        Optional<Double> totalwatthours = consumptionEquipmentPerDay.stream().reduce(Double::sum);
        return totalwatthours.get();
    }

    @Override
    public Double MininuinvesorPower(Double totalLoad) {
        return totalLoad * 1.43 ;
    }

    @Override
    public Double MaxinvesorPower(Double totalLoad) {
        return totalLoad * 2.0;
    }

    @Override
    // essa funcao corrigi a energia necessadia por dia baseado na eficiencia do inversor
    public Double correctedEnergyDay(Double inversorEficient, Double totalConsumptionEquipmentPerDay ) {
        return (totalConsumptionEquipmentPerDay / inversorEficient);
    }

    @Override
    // Essa funcao corrigi Considerando-se o rendimento global, calcula-se a energia real diária requerida, considerando todas as perdas
    // globais no sistem
    /*
    Ka = Perdas por auto-descarga nas baterias (média de 0,25%/dia)
    Kb = Perda nas baterias (média de 5% a 10%)
    Kv = Outras perdas - fator de segurança (5% a 15%)
    N = Número de dias de autonomia
    Pd = Profundidade de descarga no fim da autonomia---*/
    // valor normalmente fica na Faixa de valor (média) do rendimento global – R = 87% a 91%
    // utiliza um valor generixo aplicado na maioria dos casos = 89%
    public Double GeralenergyRequired(Double correctedEnergyDay) {
        double globalRediment = 1.89;
        return (correctedEnergyDay / globalRediment);
    }

}
