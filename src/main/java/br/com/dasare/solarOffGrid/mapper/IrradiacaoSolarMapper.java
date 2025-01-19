package br.com.dasare.solarOffGrid.mapper;

import br.com.dasare.solarOffGrid.dto.response.ResponseIrradiacaoSolar;
import br.com.dasare.solarOffGrid.entity.IrradiacaoSolar;

public class IrradiacaoSolarMapper {

    public ResponseIrradiacaoSolar entityToResponse(IrradiacaoSolar solar){

        return new ResponseIrradiacaoSolar(
                solar.getLatitude(),
                solar.getLongitude(),
                solar.getMediaAnual()/1000,
                   solar.getJaneiro()/1000,
                 solar.getFervereiro()/1000,
                solar.getMarco()/1000,
                solar.getAbril()/1000,
                solar.getMaio()/1000,
                solar.getJunho()/1000,
                solar.getJulho()/1000,
                solar.getAgosto()/1000,
                solar.getSetembro()/1000,
                solar.getOutubro()/1000,
                solar.getNovembro()/1000,
                solar.getDezembro()/1000

        );

    }



}
