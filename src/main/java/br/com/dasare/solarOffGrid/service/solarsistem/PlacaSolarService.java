package br.com.dasare.solarOffGrid.service.solarsistem;


import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateSolarPainelIntefarce;
import br.com.dasare.solarOffGrid.dto.request.RequestSolarSistemYield;
import br.com.dasare.solarOffGrid.dto.request.RequestSolarPanelToCalculate;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemYield;
import br.com.dasare.solarOffGrid.dto.response.ResponseIrradiacaoSolar;
import br.com.dasare.solarOffGrid.dto.response.ResponsePlacaSolarEntity;
import br.com.dasare.solarOffGrid.dto.response.ResponseSolarPanelCalculated;
import br.com.dasare.solarOffGrid.entity.SolarPainel;
import br.com.dasare.solarOffGrid.mapper.MapperSolarPainel;
import br.com.dasare.solarOffGrid.repository.SolarPanelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlacaSolarService {

    private final SolarPanelRepository repository;
    private final CalculateSolarPainelIntefarce panel;
    private final IrradiacaoSolarService irradiacaoSolarService;


    public PlacaSolarService(
            SolarPanelRepository repository,
            CalculateSolarPainelIntefarce panel,
            IrradiacaoSolarService irradiacaoSolarService
    ) {
        this.repository = repository;
        this.panel = panel;
        this.irradiacaoSolarService = irradiacaoSolarService;
    }

    public String salvarPlacaSolar(SolarPainel solarPainel){
        var id = repository.save(solarPainel).getMaximumPoweratStcPmax();
        return "Painel " + id+","+" Salvo com Sucesso!";
    }

    public List<ResponsePlacaSolarEntity> bringAll(){
        return new MapperSolarPainel().placaSolarEntityListToResponsePlacaSolarList(repository.findAll());
    }

    public ResponsePlacaSolarEntity bringByPower(Double power){


        return new MapperSolarPainel().placaSolarEntityToResponsePlacaSolar(repository.findSolarPainelByPower(power).get());
    }

    public ResponseSolarPanelCalculated calculatedSolarPanel(RequestSolarPanelToCalculate request){

        ResponseIrradiacaoSolar responseIrradiacaoSolar = irradiacaoSolarService.buscarIrradiacaoSolarByLocation(request.city());
        List<ResponsePlacaSolarEntity> placaSolar = bringAll();
        List<String> placaSolares = new ArrayList<>();
        double eficienciaSitema = 100.0 - request.pocentagemDePerdas();
        double irradiacaoSolarMediaDia = (responseIrradiacaoSolar.mediaAnual()*1000);
        double potenciaDoSistema = (request.loadWhdias()/((eficienciaSitema/100) * irradiacaoSolarMediaDia) )*1000;


        if (request.potenciaPlacaSolar() == 0.0) {
            placaSolar.forEach(it -> placaSolares.add(
                    String.format("Painel de %.1f = %.1f UNID",
                            Math.ceil(it.maximumPoweratSTCpmax()),
                            Math.ceil(potenciaDoSistema /it.maximumPoweratSTCpmax()))));
        }

        else placaSolares.add(String.format(
                "Painel de %.0f = %.0f UNID",request.potenciaPlacaSolar(),
                Math.ceil(potenciaDoSistema/request.potenciaPlacaSolar()))
        );

        //Double anguloIdealCorrecaoIrradiacaoSolar = Math.ceil( panel.anguloIdealCorrecaoIrradiacaoSolar(responseIrradiacaoSolar.latitude()));


        return new ResponseSolarPanelCalculated(
                request.loadWhdias(),
                request.city(),
                irradiacaoSolarMediaDia,
                eficienciaSitema,
                request.pocentagemDePerdas(),
                placaSolares
        );
    }

    public Map<Double,Double> calcularPlacarSolarSimples(Double potenciaDoSistema){

        List<ResponsePlacaSolarEntity> placaSolar = bringAll();
        Map<Double,Double> placaSolares = new HashMap<>();

            placaSolar.forEach(it -> placaSolares.put(

                Math.ceil(it.maximumPoweratSTCpmax()),
                Math.ceil(potenciaDoSistema /it.maximumPoweratSTCpmax())));

        return placaSolares;

    }



   /* public ResponseSistemYield sistemYield(RequestSolarSistemYield request){

        double sistemPowerGeneration =0.0;
        ResponseIrradiacaoSolar responseIrradiacaoSolar = irradiacaoSolarService.buscarIrradiacaoSolarByLocation(request.city());
        double irradiacaoSolarMediaDia = (responseIrradiacaoSolar.mediaAnual() * 1000);

        if (request.sistemPowerGeneration() == 0.0){
            sistemPowerGeneration = ( request.monthlyEnergyConsumption() / (( request.sistemEfficiency() / 100 ) * irradiacaoSolarMediaDia )) * 1000;
        }else {
            sistemPowerGeneration = ( request.sistemPowerGeneration() / (( request.sistemEfficiency() / 100 ) * irradiacaoSolarMediaDia )) * 1000;
        }
        double co2ReductionPerKWh = 0.5; // kg CO2 avoided per kWh
        double dailyEnergyProduction = Double.parseDouble( String.format( "%.2f",sistemPowerGeneration).replace(",","."));
        double monthlyEnergyProduction= Double.parseDouble( String.format( "%.2f",dailyEnergyProduction * 30.0).replace(",","."));
        double yearlyEnergyProduction = Double.parseDouble( String.format( "%.2f",dailyEnergyProduction * 365.0).replace(",","."));
        double monthlySavings = Double.parseDouble( String.format( "%.2f",(monthlyEnergyProduction * request.priceKWh())).replace(",","."));
        double yearlySavings = Double.parseDouble( String.format( "%.2f",(yearlyEnergyProduction * request.priceKWh())).replace(",","."));
        double roiInMonths = Double.parseDouble( String.format( "%.2f",(request.initialInvestiment() / monthlySavings)).replace(",","."));
        double monthlyCo2Redution = Double.parseDouble( String.format( "%.2f",(monthlyEnergyProduction * co2ReductionPerKWh)).replace(",","."));
        double yearlylyCo2Redution = Double.parseDouble( String.format( "%.2f",(yearlyEnergyProduction * co2ReductionPerKWh)).replace(",","."));


        return new ResponseSistemYield(
                request.city(),
            request.priceKWh(),
            request.initialInvestiment(),
            dailyEnergyProduction,
            monthlyEnergyProduction,
            yearlyEnergyProduction,
            monthlySavings,
            yearlySavings,
            roiInMonths,
            monthlyCo2Redution,
            yearlylyCo2Redution
        );

    }*/
}
