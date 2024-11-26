package br.com.dasare.solarOffGrid.domain;

public record Equipments (

    String equipmentName,
    Integer quantityEquipment,
    Double equipmentPower,
    Double hoursDailyUse
){ }
