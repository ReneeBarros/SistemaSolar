package br.com.dasare.solarOffGrid.service.solarsistem;


import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateBatteryBankInterface;
import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateSolarPainelIntefarce;
import br.com.dasare.solarOffGrid.domain.offgrid.interfac.OffGridCalculateInterface;
import br.com.dasare.solarOffGrid.dto.request.RequestCalculateSistemSolarComplete;
import br.com.dasare.solarOffGrid.dto.request.RequestOffGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversorOffGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseIrradiacaoSolar;
import br.com.dasare.solarOffGrid.dto.response.ResponsePlacaSolarEntity;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemSolarComplete;
import br.com.dasare.solarOffGrid.entity.InversorOngrid;
import br.com.dasare.solarOffGrid.repository.InversorOngridRepository;
import br.com.dasare.solarOffGrid.repository.SolarPanelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateSolarSistemService {

    private final OffGridCalculateInterface load;
    private final CalculateBatteryBankInterface baterryBank;
    private final CalculateSolarPainelIntefarce painel;
    private final InversorOngridRepository repository;
    private final InversorOffGridService service;
    private final SolarPanelRepository pvRepository;
    private final IrradiacaoSolarService irradiacaoSolarService;
    private final PlacaSolarService placaSolarService;



//SolarPanelRepository repository, preciso impelentar para trazer dados do banco de dados
    public CalculateSolarSistemService(
            OffGridCalculateInterface load,
            CalculateBatteryBankInterface baterryBank,
            CalculateSolarPainelIntefarce painel,
            InversorOngridRepository repository,
            InversorOffGridService service,
            SolarPanelRepository pvRepository,
            IrradiacaoSolarService irradiacaoSolarService,
            PlacaSolarService placaSolarService) {
        this.load = load;
        this.baterryBank = baterryBank;
        this.painel = painel;
        this.repository = repository;
        this.service = service;
        this.pvRepository = pvRepository;
        this.irradiacaoSolarService = irradiacaoSolarService;
        this.placaSolarService = placaSolarService;
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


        InversorOngrid inv = new InversorOngrid();
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
        Integer numberOfBatteriesInsires = baterryBank.numberOfBatteriesInsires(request.voltagyBatteryBank(),request.voltagyBattery());
        int numberOfBatteriesParallel = (int) Math.ceil( baterryBank.numberOfBatteriesParallel(batteryBankCapacityReal, request.capacityBateryAH()));
        int numberTotalOfBattty = (int) baterryBank.numberTotalOfBattty(numberOfBatteriesInsires, numberOfBatteriesParallel);


        // CalCulate Solarpainel

        Double currentDiariaPorArranjo = Math.ceil( painel.dailyCurrentByArrangement(GeralenergyRequiredPerDay,request.voltagyBatteryBank()));
        Integer mododeInstalacao = painel.mododeInstalacao(request.metodoInstalacao());


        ResponseIrradiacaoSolar responseIrradiacaoSolar = irradiacaoSolarService.buscarIrradiacaoSolarByLocation(request.city());
        ResponsePlacaSolarEntity placaSolar = placaSolarService.bringByPower(Double.valueOf(request.PowerOfPainelModule()));

        Double menorIrradicao = irradiacaoSolarService.encontrarMenorIrradiacao(responseIrradiacaoSolar);
        Double anguloIdealCorrecaoIrradiacaoSolar = Math.ceil( painel.anguloIdealCorrecaoIrradiacaoSolar(responseIrradiacaoSolar.latitude()));

        //temperatura de referencia virá do painel solar do banco de dados
        Double temperaturaDereferencia = 25.0;
        Double TemperatureCalculateWp = painel.TemperatureCalculateWp(request.temperaturaAmbiente(),mododeInstalacao.doubleValue(),temperaturaDereferencia );
        Integer TemperatureCalculateVoltagyMin = painel.TemperatureCalculateVoltagyMin();
        Integer TemperatureCalculateCurrentMax = painel.TemperatureCalculateCurrentMax();
        Integer TemperatureCalculateVoltagyMaxOpenCircuit = painel.TemperatureCalculateVoltagyMaxOpenCircuit();
        Double powerPicoOfModuleCorrigida = painel.powerPicoOfModuleCorrigida(placaSolar.tempCoefficientofPmax(),TemperatureCalculateWp, placaSolar.maximumPoweratSTCpmax());
        Double currentMaxOfshortCircuitCurrentIsc = painel.currentMaxOfshortCircuitCurrentIsc(placaSolar.tempCoefficientofIsc(), TemperatureCalculateCurrentMax,placaSolar.shortCircuitCurrentIsc());
        Double voltagyOpenCircutOfModuleCorrigidaVoc = painel.voltagyOpenCircutOfModuleCorrigidaVoc(placaSolar.tempCoefficientofVoc(),TemperatureCalculateVoltagyMaxOpenCircuit,placaSolar.openCircuitVoltage());
        Integer quantMoludoSerie = painel.quantMoludoSerie(request.voltagyBatteryBank(),placaSolar.optimumOperatingVoltageVmp());
        Double worstDaySolarPanelCurrent = painel.worstDaySolarPanelCurrent(placaSolar.optimumOperatingCurrentImp(),menorIrradicao);
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
            request.PowerOfPainelModule(), Double.valueOf(String.format("%.2f",powerPicoOfModuleCorrigida).replace(",",".")),
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

  private ResponseInversorOffGrid findInversor(Double load){

      if (load <= 300) {
          return service.bringByPower(300);
      } else if (load >300 && load <=500) {
          return service.bringByPower(500);
      }else if (load >500 && load <=1000) {
          return service.bringByPower(1000);
      }else if (load >1000 && load <=1500) {
          return service.bringByPower(1500);
      }else if (load >1500 && load <=2000) {
          return service.bringByPower(2000);
      }else if (load >2000 && load <=3000) {
          return service.bringByPower(3000);
      }else if (load >3000 && load <=5000) {
          return service.bringByPower(5000);
      }else{
         return null;
      }
  }

}

