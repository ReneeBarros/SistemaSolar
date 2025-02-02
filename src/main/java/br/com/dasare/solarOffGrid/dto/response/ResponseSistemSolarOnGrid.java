package br.com.dasare.solarOffGrid.dto.response;


import java.util.List;

public record ResponseSistemSolarOnGrid(

        Double mediaConsumoDiariaKwhDia,
        Double irradicaoMediaDiariaCorrigidaKwhDia,
        Double eficienciaSistema,
        Double potenciaTotalSistemaKwp,
        List<Double> potenciaPlacaWtts,
        List<Double> numeroPlacaSolar,
        Double potenciaMinimaInversorKW,
        Double potenciaMaximaInversorKw

) {
}
