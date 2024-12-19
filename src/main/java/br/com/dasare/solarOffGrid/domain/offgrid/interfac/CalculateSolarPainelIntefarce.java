package br.com.dasare.solarOffGrid.domain.offgrid.interfac;


import java.util.List;

public interface CalculateSolarPainelIntefarce {

    Double witchCargeController(String chargeController);
    Double dailyCurrentByArrangement(Double energyPowerPerDay, Integer voltagyBattryBank );
    Integer mododeInstalacao(String tipoFixacaoModulo);
    Double anguloIdealCorrecaoIrradiacaoSolar(Double latitutde);
    List<Double> irradiacaoSolarCorrigida(List<Double>irradiacaoSolar, List<Double>fatorCorrecao);
    Double TemperatureCalculateWp(Double tempAmbiente,Double deltaT, Double tempReferencia);
    Integer TemperatureCalculateVoltagyMin();
    Integer TemperatureCalculateCurrentMax();
    Integer TemperatureCalculateVoltagyMaxOpenCircuit();
    Double powerPicoOfModuleCorrigida( Double tempCoefficientofPmax,Double TemperatureCalculateWp,Double powerSolarPainel);
    Double currentMaxOfshortCircuitCurrentIsc(Double tempCoefficientofIsc,Integer TemperatureCalculateCurrentMax,Double shortCircuitCurrentIsc );
    Double voltagyOpenCircutOfModuleCorrigidaVoc(Double tempCoefficientofVo,Integer TemperatureCalculateVoltagyMaxOpenCircuit,Double openCircuitVoltage);
    Integer quantMoludoSerie(Integer batteryVoltagy, Double optimumOperatingVoltageVmp);
    Double worstDaySolarPanelCurrent(Double shortCircuitCurrentIsc,Double irradiacaoSolarPiorCaso);
    Integer numberSolarPanelsParallel(Double worstDaySolarPanelCurrent, Double calculatedCurrentOfSistem );
    public Integer numberSolarPanels(Integer numberSolarPanelsParallel, Integer quantMoludoSerie );
    Integer chargeControllerCurrentMustSuport ( Double currentMaxOfModuleCorrigida, Integer numberSolarPanelsParallel );
}
