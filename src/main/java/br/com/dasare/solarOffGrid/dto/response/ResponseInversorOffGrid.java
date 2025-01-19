package br.com.dasare.solarOffGrid.dto.response;

public record ResponseInversorOffGrid(
        Long id,
        String marca,
        Double tensaoNorminalEntrada,
        Integer potenciaSaidaNorminal,
        Integer potenciaSaidaPico,
        Integer tensaoNorminalSaida,
        String formaOnda,
        String frequenciasaida,
        Double eficienciaInversor,
        String dimensao
) {
}
