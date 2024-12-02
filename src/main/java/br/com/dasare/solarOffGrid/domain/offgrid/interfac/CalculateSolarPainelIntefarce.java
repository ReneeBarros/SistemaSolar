package br.com.dasare.solarOffGrid.domain.offgrid.interfac;



public interface CalculateSolarPainelIntefarce {

    Double witchCargeController(String chargeController);
    Double ourrentDiariaPorArranjo(Double energyPowerPerDay,Integer voltagyBattryBank );


}
