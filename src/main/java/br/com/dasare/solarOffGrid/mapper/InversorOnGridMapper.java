package br.com.dasare.solarOffGrid.mapper;

import br.com.dasare.solarOffGrid.dto.request.RequestInversorOngrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversorOngrid;
import br.com.dasare.solarOffGrid.entity.InversorOngrid;

import java.util.ArrayList;
import java.util.List;

public class InversorOnGridMapper {


   public ResponseInversorOngrid inversorToResponseInversor (InversorOngrid inversorOngrid){
       return new ResponseInversorOngrid(
               inversorOngrid.getId(),
               inversorOngrid.getMarcaInversor(),
               inversorOngrid.getLinhaInversor(),
               inversorOngrid.getModelo(),
               inversorOngrid.getPotenciaMaxEntradaCC(),
               inversorOngrid.getTensaoCCMaxEntrada(),
               inversorOngrid.getTensaoNorminalCCEntrada(),
               inversorOngrid.getCorrenteMaxEntradaPorMPPT(),
               inversorOngrid.getCorrenteMaxCurtoPorMPPT(),
               inversorOngrid.getNumeroMPPT(),
               inversorOngrid.getNumeroStringsMPPT(),
               inversorOngrid.getPotenciaMaxAcSaida(),
               inversorOngrid.getTensaoNorminalAcSaida(),
               inversorOngrid.getCorrenteMaxAcSaida(),
               inversorOngrid.getEficienciaMax()
       );
   }

   public List<ResponseInversorOngrid> listOfInversorToListOfResponseInversor (List<InversorOngrid> inversorOngrid){
       List<ResponseInversorOngrid> responseInversorOngrids = new ArrayList<>();
       inversorOngrid.forEach(inversorOngrid1 ->
               responseInversorOngrids.add(inversorToResponseInversor(inversorOngrid1))
       );
       return responseInversorOngrids;
   }

   public InversorOngrid requestInversorToInversorEntity(RequestInversorOngrid request){

       return new InversorOngrid(
               null,
               request.marcaInversor(),
               request.linhaInversor(),
               request.modelo(),
               request.potenciaMaxEntradaCC(),
               request.tensaoCCMaxEntrada(),
               request.tensaoNorminalCCEntrada(),
               request.correnteMaxEntradaPorMPPT(),
               request.correnteMaxCurtoPorMPPT(),
               request.numeroMPPT(),
               request.numeroStringsMPPT(),
               request.potenciaMaxAcSaida(),
               request.tensaoNorminalAcSaida(),
               request.correnteMaxCurtoPorMPPT(),
               request.eficienciaMax()
       );

   }

}
