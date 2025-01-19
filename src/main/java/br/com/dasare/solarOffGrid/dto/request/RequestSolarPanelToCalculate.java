package br.com.dasare.solarOffGrid.dto.request;

public record RequestSolarPanelToCalculate(

        String city,
        Double loadWhdias,
        Double pocentagemDePerdas,
        Double potenciaPlacaSolar

) {
}
