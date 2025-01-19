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
    public Double dailyCurrentByArrangement(Double energyPowerPerDay, Integer voltagyBattryBank) {
        return (energyPowerPerDay / voltagyBattryBank);
    }

    @Override
    // essa funcao dertemina a funcao do em que os arranjos serao instalado com isso determina o Delta T para caluclo de potencia real do painel
    public Integer mododeInstalacao(String tipoFixacaoModulo){
        Map<String, Integer> tipoFixacao = new HashMap<>();
        tipoFixacao.put("Estrutura no Solo",22);
        tipoFixacao.put("Laje ou Telhado Com espaco",28);
        tipoFixacao.put("Sobre o Telhado com ventilacao",29);
        tipoFixacao.put("Sobre o Telhado Sem ventilacao",32);
        return tipoFixacao.get(tipoFixacaoModulo);
    }


    @Override
    // ideal para paineis em que o instalador tem a liberdade para escolher o angulo de instalação dos arranjo fotvoltaico
    public Double anguloIdealCorrecaoIrradiacaoSolar(Double latitutde){
        return latitutde + (latitutde/4);
    }

    @Override
    public List<Double> irradiacaoSolarCorrigida(List<Double>irradiacaoSolar, List<Double>fatorCorrecao){

        List<Double> irradicaoCorrigida = new ArrayList<>();

        for (int i = 0; i < irradiacaoSolar.size() ; i++) {
            irradicaoCorrigida.add(
                    (irradiacaoSolar.get(i) * fatorCorrecao.get(i))
            );
        }
        return irradicaoCorrigida;
    }
    @Override
    // temperatura de calculo de potencia pico temperatura para calcular a potencia real
    // dos paineis fotovoltaico ( Tcalc.Wp = Tamb + (AT - (Temperatura de referencia)))
    public Double TemperatureCalculateWp(Double tempAmbiente,Double deltaT, Double tempReferencia){
        return (tempAmbiente+(deltaT - tempReferencia));
    }




    // Temperatura de cálculo para tensão máxima de curto circuito:
    // Tcalc.Voc.Max = Tamb + deltaT - Tref
    /*
    Para o cálculo do Voc,max e utiliza-se um valor de Tamb
    internacionalmente aceito de -10 °C. Esse valor provém
    de estudos que determinaram a temperatura média da
    célula fotovoltaica durante a incidência dos primeiros
    raios solares durante a manhã. Como durante esse
    período as células estão iniciando seu trabalho, não há
    diferença de temperatura entre o meio ambiente e as
    células, logo utiliza-se um Δt ° = 0
    * */
    public Integer TemperatureCalculateVoltagyMaxOfCurtoCircuito(){
        return (-10 - 25);
    }

    @Override
    // Temperatura de cálculo para tensão mínima de operação
    // Tcalc,Isc, max = 85−25 = 60 °C
    public Integer TemperatureCalculateVoltagyMin(){
        return (85 - 25);
    }

    @Override
    // Temperatura de cálculo para corrente máxima de curto circuito
    // Tcalc,Isc, max = 85−25 = 60 °C
    public Integer TemperatureCalculateCurrentMax(){
        return (85 - 25);
    }

    @Override
    public Integer TemperatureCalculateVoltagyMaxOpenCircuit(){
        return (-25);
    }

    @Override
                                                     // vem da placa
    public Double powerPicoOfModuleCorrigida( Double tempCoefficientofPmax, Double TemperatureCalculateWp, Double powerSolarPainel){
        return (((100 + (tempCoefficientofPmax * TemperatureCalculateWp))/100) * powerSolarPainel);
    }

    @Override
    // corigir a corrente maxima do painel pela temperatura
    public Double currentMaxOfshortCircuitCurrentIsc(
            Double tempCoefficientofIsc,
            Integer TemperatureCalculateCurrentMax,
            Double shortCircuitCurrentIsc ){

        return (((100 + (tempCoefficientofIsc * TemperatureCalculateCurrentMax))/100) * shortCircuitCurrentIsc);

    }

    @Override
    public Double voltagyOpenCircutOfModuleCorrigidaVoc(

            Double tempCoefficientofVo,
            Integer TemperatureCalculateVoltagyMaxOpenCircuit,
            Double openCircuitVoltage
    ){
        return (((100 + (tempCoefficientofVo * TemperatureCalculateVoltagyMaxOpenCircuit))/100) * openCircuitVoltage);
    }

    @Override
    public Integer quantMoludoSerie(Integer batteryVoltagyBank, Double optimumOperatingVoltageVmp){

        return (int) Math.ceil((1.5 * batteryVoltagyBank)/optimumOperatingVoltageVmp);
    }

    @Override
    public Double worstDaySolarPanelCurrent(Double operatingCurrentImp, Double irradiacaoSolarPiorCaso){
        return operatingCurrentImp * irradiacaoSolarPiorCaso;
    }

    @Override
    public Integer numberSolarPanelsParallel(Double worstDaySolarPanelCurrent, Double calculatedCurrentOfSistem ){
        return (int) (calculatedCurrentOfSistem / worstDaySolarPanelCurrent);
    }

    @Override
    public Integer numberSolarPanels(Integer numberSolarPanelsParallel, Integer quantMoludoSerie ){
        return (quantMoludoSerie * numberSolarPanelsParallel);
    }

    @Override
    public Integer chargeControllerCurrentMustSuport ( Double currentMaxOfModuleCorrigida, Integer numberSolarPanelsParallel ){
        return (int) (1.25 * (numberSolarPanelsParallel * currentMaxOfModuleCorrigida));

    }

}
