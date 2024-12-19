package br.com.dasare.solarOffGrid.entity;


import jakarta.persistence.*;

@Entity
public class SolarPainel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double openCircuitVoltage;
    Double optimumOperatingVoltageVmp;
    Double shortCircuitCurrentIsc;
    Double optimumOperatingCurrentImp;
    Double maximumPoweratSTCpmax;
    String operatingTemperature;
    String nominalOperatingCellTemperature;
    Double tempCoefficientofPmax;
    Double tempCoefficientofVoc;
    Double tempCoefficientofIsc;

    public SolarPainel() {
    }

    public SolarPainel(Double openCircuitVoltage,
                       Double optimumOperatingVoltageVmp, Double shortCircuitCurrentIsc,
                       Double optimumOperatingCurrentImp, Double maximumPoweratSTCpmax,
                       String operatingTemperature, String nominalOperatingCellTemperature,
                       Double tempCoefficientofPmax, Double tempCoefficientofVoc,
                       Double tempCoefficientofIsc) {
        this.openCircuitVoltage = openCircuitVoltage;
        this.optimumOperatingVoltageVmp = optimumOperatingVoltageVmp;
        this.shortCircuitCurrentIsc = shortCircuitCurrentIsc;
        this.optimumOperatingCurrentImp = optimumOperatingCurrentImp;
        this.maximumPoweratSTCpmax = maximumPoweratSTCpmax;
        this.operatingTemperature = operatingTemperature;
        this.nominalOperatingCellTemperature = nominalOperatingCellTemperature;
        this.tempCoefficientofPmax = tempCoefficientofPmax;
        this.tempCoefficientofVoc = tempCoefficientofVoc;
        this.tempCoefficientofIsc = tempCoefficientofIsc;
    }

    public Long getId() {
        return id;
    }

    public Double getOpenCircuitVoltage() {
        return openCircuitVoltage;
    }

    public Double getOptimumOperatingVoltageVmp() {
        return optimumOperatingVoltageVmp;
    }

    public Double getShortCircuitCurrentIsc() {
        return shortCircuitCurrentIsc;
    }

    public Double getOptimumOperatingCurrentImp() {
        return optimumOperatingCurrentImp;
    }

    public Double getMaximumPoweratSTCpmax() {
        return maximumPoweratSTCpmax;
    }

    public String getOperatingTemperature() {
        return operatingTemperature;
    }

    public String getNominalOperatingCellTemperature() {
        return nominalOperatingCellTemperature;
    }

    public Double getTempCoefficientofPmax() {
        return tempCoefficientofPmax;
    }

    public Double getTempCoefficientofVoc() {
        return tempCoefficientofVoc;
    }

    public Double getTempCoefficientofIsc() {
        return tempCoefficientofIsc;
    }

    public void setOpenCircuitVoltage(Double openCircuitVoltage) {
        this.openCircuitVoltage = openCircuitVoltage;
    }

    public void setOptimumOperatingVoltageVmp(Double optimumOperatingVoltageVmp) {
        this.optimumOperatingVoltageVmp = optimumOperatingVoltageVmp;
    }

    public void setShortCircuitCurrentIsc(Double shortCircuitCurrentIsc) {
        this.shortCircuitCurrentIsc = shortCircuitCurrentIsc;
    }

    public void setOptimumOperatingCurrentImp(Double optimumOperatingCurrentImp) {
        this.optimumOperatingCurrentImp = optimumOperatingCurrentImp;
    }

    public void setMaximumPoweratSTCpmax(Double maximumPoweratSTCpmax) {
        this.maximumPoweratSTCpmax = maximumPoweratSTCpmax;
    }

    public void setOperatingTemperature(String operatingTemperature) {
        this.operatingTemperature = operatingTemperature;
    }

    public void setNominalOperatingCellTemperature(String nominalOperatingCellTemperature) {
        this.nominalOperatingCellTemperature = nominalOperatingCellTemperature;
    }

    public void setTempCoefficientofPmax(Double tempCoefficientofPmax) {
        this.tempCoefficientofPmax = tempCoefficientofPmax;
    }

    public void setTempCoefficientofVoc(Double tempCoefficientofVoc) {
        this.tempCoefficientofVoc = tempCoefficientofVoc;
    }

    public void setTempCoefficientofIsc(Double tempCoefficientofIsc) {
        this.tempCoefficientofIsc = tempCoefficientofIsc;
    }
}
