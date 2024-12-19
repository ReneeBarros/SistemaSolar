package br.com.dasare.solarOffGrid.mapper;

import br.com.dasare.solarOffGrid.dto.request.RequestPlacaSolar;
import br.com.dasare.solarOffGrid.dto.response.ResponsePlacaSolar;
import br.com.dasare.solarOffGrid.entity.SolarPainel;

import java.util.ArrayList;
import java.util.List;

public class MapperRequestToEntitySolarPainel {


    public SolarPainel requestSolarpainelToEntitySolarpainel(RequestPlacaSolar request){
        return new SolarPainel(
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

    public List<ResponsePlacaSolar> placaSolarEntityListToResponsePlacaSolarList(List<SolarPainel> painelSolar){
        List<ResponsePlacaSolar> response =new ArrayList<>();
        painelSolar.forEach(
                painel ->{
                   response.add( placaSolarEntityToResponsePlacaSolar(painel));
                }
        );
       return response;
    }

    public ResponsePlacaSolar placaSolarEntityToResponsePlacaSolar(SolarPainel painelSolar){
        return new ResponsePlacaSolar(
            painelSolar.getId(),
            painelSolar.getOpenCircuitVoltage(),
            painelSolar.getOptimumOperatingVoltageVmp(),
            painelSolar.getShortCircuitCurrentIsc(),
            painelSolar.getOptimumOperatingCurrentImp(),
            painelSolar.getMaximumPoweratSTCpmax(),
            painelSolar.getOperatingTemperature(),
            painelSolar.getNominalOperatingCellTemperature(),
            painelSolar.getTempCoefficientofPmax(),
            painelSolar.getTempCoefficientofVoc(),
            painelSolar.getTempCoefficientofIsc()

        );
    }
}
