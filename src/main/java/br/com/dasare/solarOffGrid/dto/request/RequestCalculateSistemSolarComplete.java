package br.com.dasare.solarOffGrid.dto.request;

import br.com.dasare.solarOffGrid.domain.Equipments;

import java.util.List;

public record RequestCalculateSistemSolarComplete(

        String city,
        List<Equipments> equipments,
        Double autonomyDay,
        Integer voltagyBatteryBank,
        Double dischargeDepthOfBatteryBank,
        Integer voltagyBattery,
        Double capacityBateryAH,
        String metodoInstalacao,
        Double temperaturaAmbiente,
        Integer PowerOfPainelModule
) {}
