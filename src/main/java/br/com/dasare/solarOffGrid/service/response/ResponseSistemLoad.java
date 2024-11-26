package br.com.dasare.solarOffGrid.service.response;

import java.util.List;

public record ResponseSistemLoad(
        List<Double> listLoad,
        List<Double> listConsumptionEquipmentPerDay,
        Double totalLoad,
        Double totalConsumptionEquipmentPerDay,
        Double correctedEnergyDay,
        Double GeralenergyRequired,
        Double MininuinvesorPower,
        Double MaxinvesorPower

) {}


