package br.com.dasare.solarOffGrid.mapper;

import br.com.dasare.solarOffGrid.dto.response.ResponseInversor;
import br.com.dasare.solarOffGrid.entity.Inversor;

import java.util.ArrayList;
import java.util.List;

public class InversorMapper {


   public ResponseInversor inversorToResponseInversor (Inversor inversor){
       return new ResponseInversor(
               inversor.getId(),
               inversor.getMarcaInversor(),
               inversor.getLinhaInversor(),
               inversor.getModelo(),
               inversor.getPotenciaMaxEntradaCC(),
               inversor.getTensaoCCMaxEntrada(),
               inversor.getTensaoNorminalCCEntrada(),
               inversor.getCorrenteMaxEntradaPorMPPT(),
               inversor.getCorrenteMaxCurtoPorMPPT(),
               inversor.getNumeroMPPT(),
               inversor.getNumeroStringsMPPT(),
               inversor.getPotenciaMaxAcSaida(),
               inversor.getTensaoNorminalAcSaida(),
               inversor.getCorrenteMaxAcSaida(),
               inversor.getEficienciaMax()
       );
   }

   public List<ResponseInversor> listOfInversorToListOfResponseInversor (List<Inversor> inversor){
       List<ResponseInversor> responseInversors = new ArrayList<>();
       inversor.forEach(inversor1 ->
               responseInversors.add(inversorToResponseInversor(inversor1))
       );
       return responseInversors;
   }

}
