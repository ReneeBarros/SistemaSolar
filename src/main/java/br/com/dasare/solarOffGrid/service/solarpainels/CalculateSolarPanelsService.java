package br.com.dasare.solarOffGrid.service.solarpainels;


import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateBatteryBankInterface;
import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateSolarPainelIntefarce;
import br.com.dasare.solarOffGrid.domain.offgrid.interfac.OffGridCalculateInterface;
import br.com.dasare.solarOffGrid.dto.request.RequestCalculateSistemSolarComplete;
import br.com.dasare.solarOffGrid.dto.request.RequestOffGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemSolarComplete;
import br.com.dasare.solarOffGrid.entity.Inversor;
import br.com.dasare.solarOffGrid.repository.InversorRepository;
import br.com.dasare.solarOffGrid.repository.SolarPanelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateSolarPanelsService {


    private final OffGridCalculateInterface load;
    private final CalculateBatteryBankInterface baterryBank;
    private final CalculateSolarPainelIntefarce painel;
    private final InversorRepository repository;

//SolarPanelRepository repository, preciso impelentar para trazer dados do banco de dados
    public CalculateSolarPanelsService(OffGridCalculateInterface load, CalculateBatteryBankInterface baterryBank, CalculateSolarPainelIntefarce painel, InversorRepository repository) {
        this.load = load;
        this.baterryBank = baterryBank;
        this.painel = painel;
        this.repository = repository;
    }

    public ResponseSistemSolarComplete calculateSitemSolarComplete(RequestCalculateSistemSolarComplete request){

        RequestOffGrid req = new RequestOffGrid(
                request.city(),
                request.equipments()
        );

        // Calculate Charge from client Home
        List<Double> load1 = load.load(req);
        List<Double> consumptionEquipmentPerDay = load.consumptionEquipmentPerDay(load1, req);
        Double totalLoad = load.totalLoad(load1);
        Double totalConsumptionEquipmentPerDay = load.totalConsumptionEquipmentPerDay(consumptionEquipmentPerDay);
        /*
        * aqui fazer o codigo para trazer refenrencia do banco de dados para lançar o inversor escolhido pelo sistema para o usuario
        *
        */
        Double minInversorPower = load.MininuinvesorPower(totalLoad);
        Double maxInversorPower = load.MaxinvesorPower(totalLoad);


        Inversor inv = new Inversor();
          Double  efficienciaInversor = repository.findInversorByPower(totalLoad).orElse(inv).getEficienciaMax();
          if(efficienciaInversor == null){
              efficienciaInversor = 0.90;
          }

        Double correctedTotalEnergyDay = load.correctedEnergyDay(efficienciaInversor, totalConsumptionEquipmentPerDay);

        // Essa funcao corrigi Considerando-se o rendimento global, calcula-se a energia real diária requerida, considerando todas as perdas
        // globais no sistem
        Double GeralenergyRequiredPerDay =Math.ceil( load.GeralenergyRequired(correctedTotalEnergyDay));


        // CalCulate Battery
        Integer voltagemDoInversor=24; // precisa trazer essa informação do banco
        Integer batteryBankCapacityUseful = baterryBank.BatteryBankCapacityUseful(GeralenergyRequiredPerDay, request.autonomyDay(), request.voltagyBatteryBank());
        Integer batteryBankCapacityReal = baterryBank.batteryBankCapacityReal(batteryBankCapacityUseful,request.dischargeDepthOfBatteryBank());
        Integer numberOfBatteriesInsires = baterryBank.numberOfBatteriesInsires(voltagemDoInversor,request.voltagyBattery());
        Integer numberOfBatteriesParallel = baterryBank.numberOfBatteriesParallel(batteryBankCapacityReal, request.capacityBateryAH());
        Integer numberTotalOfBattty = baterryBank.numberTotalOfBattty(numberOfBatteriesInsires, numberOfBatteriesParallel);


        // Calculate Solar Panel
        Double currentDiariaPorArranjo = Math.ceil( painel.dailyCurrentByArrangement(GeralenergyRequiredPerDay,request.voltagyBatteryBank()));
        Integer mododeInstalacao = painel.mododeInstalacao(request.metodoInstalacao());

        // conseguir latitude apartir do banco de dados quando o usuario informar a cidade onde será instalado o sistema
        Double anguloIdealCorrecaoIrradiacaoSolar = Math.ceil( painel.anguloIdealCorrecaoIrradiacaoSolar(16.75));

        //temperatura de referencia virá do painel solar do banco de dados
        Double temperaturaDereferencia = 25.0;
        Double TemperatureCalculateWp = painel.TemperatureCalculateWp(request.temperaturaAmbiente(),mododeInstalacao.doubleValue(),temperaturaDereferencia );
        Integer TemperatureCalculateVoltagyMin = painel.TemperatureCalculateVoltagyMin();
        Integer TemperatureCalculateCurrentMax = painel.TemperatureCalculateCurrentMax();
        Integer TemperatureCalculateVoltagyMaxOpenCircuit = painel.TemperatureCalculateVoltagyMaxOpenCircuit();

        // essa informacao da potencia do painel vem do banco de dados
        Double potenciaDoPainelSolar = Double.valueOf(request.PowerOfPainelModule());

        // essa informacao da potencia do painel vem do banco de dados
        Double correnteDeCurtoCicuitoDoPainelSolar = 3.12;

        // essa informacao da potencia do painel vem do banco de dados
        Double openCircuitVoltagy = 21.8;

        Double powerPicoOfModuleCorrigida = painel.powerPicoOfModuleCorrigida(0.47,TemperatureCalculateWp,potenciaDoPainelSolar);
        Double currentMaxOfshortCircuitCurrentIsc = painel.currentMaxOfshortCircuitCurrentIsc(0.045, TemperatureCalculateCurrentMax,correnteDeCurtoCicuitoDoPainelSolar);
        Double voltagyOpenCircutOfModuleCorrigidaVoc = painel.voltagyOpenCircutOfModuleCorrigidaVoc(0.34,TemperatureCalculateVoltagyMaxOpenCircuit,openCircuitVoltagy);
        Integer quantMoludoSerie = painel.quantMoludoSerie(request.voltagyBatteryBank(),17.4);
        Double worstDaySolarPanelCurrent = painel.worstDaySolarPanelCurrent(2.93,3.86);
        Integer numberSolarPanelsParallel = painel.numberSolarPanelsParallel(worstDaySolarPanelCurrent,currentDiariaPorArranjo);
        Integer quantityTotalOfModule = painel.numberSolarPanels(quantMoludoSerie,numberSolarPanelsParallel);


        return new ResponseSistemSolarComplete(
            req.city(),
            totalLoad,
            GeralenergyRequiredPerDay,
            batteryBankCapacityReal,
            numberOfBatteriesInsires,
            numberOfBatteriesParallel,
            numberTotalOfBattty,
            request.capacityBateryAH(),
            request.PowerOfPainelModule(),
            powerPicoOfModuleCorrigida,
            currentDiariaPorArranjo,
            anguloIdealCorrecaoIrradiacaoSolar,
            quantMoludoSerie,
            Double.valueOf(String.format("%.2f",worstDaySolarPanelCurrent).replace(",",".")),
            numberSolarPanelsParallel,
            quantityTotalOfModule,
            minInversorPower,
            maxInversorPower
        );
    }
}

