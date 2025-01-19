package br.com.dasare.solarOffGrid.dto.request;

public record RequestInversorOffGrid(
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
