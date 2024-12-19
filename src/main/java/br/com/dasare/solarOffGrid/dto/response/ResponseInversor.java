package br.com.dasare.solarOffGrid.dto.response;

public record ResponseInversor(
        Long id,
        String marcaInversor,
        String linhaInversor,
        String modelo,
        Double potenciaMaxEntradaCC,
        Integer tensaoCCMaxEntrada,
        Integer tensaoNorminalCCEntrada,
        Double correnteMaxEntradaPorMPPT,
        Double correnteMaxCurtoPorMPPT,
        Integer numeroMPPT,
        Integer numeroStringsMPPT,
        Double potenciaMaxAcSaida,
        String tensaoNorminalAcSaida,
        Double correnteMaxAcSaida,
        Double eficienciaMax
) {
}
