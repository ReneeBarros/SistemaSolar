package br.com.dasare.solarOffGrid.mapper;

import br.com.dasare.solarOffGrid.dto.request.RequestPlacaSolarEntity;
import br.com.dasare.solarOffGrid.dto.response.ResponsePlacaSolarEntity;
import br.com.dasare.solarOffGrid.entity.SolarPainel;

import java.util.ArrayList;
import java.util.List;

public class MapperSolarPainel {


    public SolarPainel requestSolarpainelToEntitySolarpainel(RequestPlacaSolarEntity request){
        return new SolarPainel(
                request.marcaSolarPainel(),
                request.pvModuleEfficienty(),
                request.pvType(),
                request.openCircuitVoltage(),
                request.optimumOperatingVoltageVmp(),
                request.shortCircuitCurrentIsc(),
                request.optimumOperatingCurrentImp(),
                request.maximumPoweratSTCpmax(),
                request.operatingTemperature(),
                request.nominalOperatingCellTemperature(),
                request.tempCoefficientofPmax(),
                request.tempCoefficientofVoc(),
                request.tempCoefficientofIsc()
        );
    }

    public List<ResponsePlacaSolarEntity> placaSolarEntityListToResponsePlacaSolarList(List<SolarPainel> painelSolar){
        List<ResponsePlacaSolarEntity> response =new ArrayList<>();
        painelSolar.forEach(
                painel ->{
                   response.add( placaSolarEntityToResponsePlacaSolar(painel));
                }
        );
       return response;
    }

    public ResponsePlacaSolarEntity placaSolarEntityToResponsePlacaSolar(SolarPainel painelSolar){
        return new ResponsePlacaSolarEntity(
            painelSolar.getId(),
            painelSolar.getMarcaSolarPainel(),
            painelSolar.getPvModuleEfficiency(),
            painelSolar.getPvType(),
            painelSolar.getOpenCircuitVoltage(),
            painelSolar.getOptimumOperatingVoltageVmp(),
            painelSolar.getShortCircuitCurrentIsc(),
            painelSolar.getOptimumOperatingCurrentImp(),
            painelSolar.getMaximumPoweratStcPmax(),
            painelSolar.getOperatingTemperature(),
            painelSolar.getNominalOperatingCellTemperature(),
            painelSolar.getTempCoefficientofPmax(),
            painelSolar.getTempCoefficientofVoc(),
            painelSolar.getTempCoefficientofIsc()
        );
    }
}
