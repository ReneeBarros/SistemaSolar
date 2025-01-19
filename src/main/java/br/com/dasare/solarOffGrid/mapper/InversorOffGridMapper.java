package br.com.dasare.solarOffGrid.mapper;


import br.com.dasare.solarOffGrid.dto.request.RequestInversorOffGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversorOffGrid;
import br.com.dasare.solarOffGrid.entity.InversorOffGridEntity;

import java.util.ArrayList;
import java.util.List;

public class InversorOffGridMapper {


    public InversorOffGridEntity fromRequestToOffgridInversorEntity(RequestInversorOffGrid request) {

        return new InversorOffGridEntity(
            request.marca(),
            request.tensaoNorminalEntrada(),
            request.potenciaSaidaNorminal(),
            request.potenciaSaidaPico(),
            request.tensaoNorminalSaida(),
            request.formaOnda(),
            request.frequenciasaida(),
            request.eficienciaInversor(),
            request.dimensao()
        );
    }


    public ResponseInversorOffGrid fromOffGridInversorEntityToResponse(InversorOffGridEntity entity) {

        return new ResponseInversorOffGrid(
                entity.getId(),
                entity.getMarca(),
                entity.getTensaoNorminalEntrada(),
                entity.getPotenciaSaidaNorminal(),
                entity.getPotenciaSaidaPico(),
                entity.getTensaoNorminalSaida(),
                entity.getFormaOnda(),
                entity.getFrequenciasaida(),
                entity.getEficienciaInversor(),
                entity.getDimensao()
        );

    }

    public List<ResponseInversorOffGrid> listFromOffGridInversorEntityToResponse(List<InversorOffGridEntity> entity) {

        List<ResponseInversorOffGrid> listResponse = new ArrayList<>();
        entity.forEach(
                entity1 -> {
                    listResponse.add(fromOffGridInversorEntityToResponse(entity1));
                }
        );
        return listResponse;
    }


}
