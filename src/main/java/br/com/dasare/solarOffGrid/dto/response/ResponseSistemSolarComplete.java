package br.com.dasare.solarOffGrid.dto.response;



public record ResponseSistemSolarComplete(

    String city,
    Double totalLoad,
    Double GeralenergyRequired,
    Integer batteryBankCapacityReal,
    Integer numberOfBatteriesInsires,
    Integer numberOfBatteriesParallel,
    Integer numberTotalOfBattty,
    Integer capacityBateryAH,
    Integer PowerOfPainelModule,
    Double powerPicoOfModuleCorrigida,
    Double currentDiariaPorArranjo,
    Double anguloIdealCorrecaoIrradiacaoSolar,
    Integer quantMoludoSerie,
    Double worstDaySolarPanelCurrent,
    Integer numberSolarPanelsParallel,
    Integer quantityTotalOfModule,
    Double MimPowerInvesor,
    Double MaxPowerInversor

) {
}
