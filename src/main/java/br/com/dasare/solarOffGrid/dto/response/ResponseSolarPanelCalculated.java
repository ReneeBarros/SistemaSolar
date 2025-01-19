package br.com.dasare.solarOffGrid.dto.response;

import java.util.List;

public record ResponseSolarPanelCalculated(

        Double loadSistem,
        String city,
        Double solarIrradiationDay,
        Double systemEfficiency,
        Double lossPercentage,
        List<String> differentPowerPanels

) {
}
