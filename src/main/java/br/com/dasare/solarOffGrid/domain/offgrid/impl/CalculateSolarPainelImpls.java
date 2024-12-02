package br.com.dasare.solarOffGrid.domain.offgrid.impl;

import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateSolarPainelIntefarce;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateSolarPainelImpls implements CalculateSolarPainelIntefarce {


    @Override
    public Double witchCargeController(String chargeController) {
        return 0.0;
    }

    @Override
    public Double ourrentDiariaPorArranjo(Double energyPowerPerDay, Integer voltagyBattryBank) {
        return (energyPowerPerDay / voltagyBattryBank);
    }

    public Integer mododeInstalacao(String tipoFixacaoModulo){
        Map<String, Integer> tipoFixacao = new HashMap<>();
        tipoFixacao.put("Estrutura no Solo",22);
        tipoFixacao.put("Laje ou Telhado Com espaco",28);
        tipoFixacao.put("Sobre o Telhado com ventilacao",29);
        tipoFixacao.put("Sobre o Telhado Sem ventilacao",32);
        return tipoFixacao.get(tipoFixacaoModulo);
    }


    // ideal para paineis em que o instalador tem a liberdade para escolher o angulo de instalação dos arranjo fotvoltaico
    public Double anguloIdealCorrecaoIrradiacaoSolar(Double latitutde){
        return latitutde + (latitutde/4);
    }

    public List<Double> irradiacaoSolarCorrigida(List<Double>irradiacaoSolar, List<Double>fatorCorrecao){

        List<Double> irradicaoCorrigida = new ArrayList<>();

        for (int i = 0; i < irradiacaoSolar.size() ; i++) {
            irradicaoCorrigida.add(
                    (irradiacaoSolar.get(i) * fatorCorrecao.get(i))
            );
        }
        return irradicaoCorrigida;
    }
    // temperatura de calculo de potencia pico temperatura para calcular a potencia real
    // dos paineis fotovoltaico ( Tcalc.Wp = Tamb + (AT - (Temperatura de referencia)))
    public Double TemperatureCalculateWp(Double tempAmbiente,Double deltaT, Double tempReferencia){
        return (tempAmbiente+(deltaT - tempReferencia));
    }

    public Integer TemperatureCalculateVoltagyMin(){
        return (85 - 25);
    }

    public Integer TemperatureCalculateCurrentMax(){
        return (85 - 25);
    }

    public Integer TemperatureCalculateVoltagyMaxOpenCircuit(){
        return (25);
    }


    public Double powerPicoOfModuleCorrigida( Double tempCoefficientofPmax,Double TemperatureCalculateWp,Double powerSolarPainel){
        return (((100 + (-tempCoefficientofPmax * TemperatureCalculateWp))/100) * powerSolarPainel);
    }

    public Double currentMaxOfModuleCorrigida(
            Double tempCoefficientofIsc,
            Integer TemperatureCalculateCurrentMax,
            Double shortCircuitCurrentIsc ){

        return (((100 + (tempCoefficientofIsc * TemperatureCalculateCurrentMax))/100) * shortCircuitCurrentIsc);

    }

    public Double voltagyOpenCircutOfModuleCorrigidaVoc(

            Double tempCoefficientofVo,
            Integer TemperatureCalculateVoltagyMaxOpenCircuit,
            Double openCircuitVoltage
    ){
        return (((100 + (-tempCoefficientofVo * TemperatureCalculateVoltagyMaxOpenCircuit))/100) * openCircuitVoltage);
    }

    public Integer quantMoludoSerie(Integer batteryVoltagy, Double nominalVoltagyOfModulo){

        return (int) ((1.5*batteryVoltagy)/nominalVoltagyOfModulo);

    }

    public Double worstDaySolarPanelCurrent(Double shortCircuitCurrentIsc,Double irradiacaoSolarPiorCaso){
        return shortCircuitCurrentIsc * irradiacaoSolarPiorCaso;
    }

    public Integer numberSolarPanelsParallel(Double worstDaySolarPanelCurrent, Double calculatedCurrentOfSistem ){
        return (int) (calculatedCurrentOfSistem / worstDaySolarPanelCurrent);
    }

    public Integer chargeControllerCurrentMustSuport ( Double currentMaxOfModuleCorrigida, Integer numberSolarPanelsParallel ){
        return (int) (1.25 * (numberSolarPanelsParallel * currentMaxOfModuleCorrigida));

    }

}
