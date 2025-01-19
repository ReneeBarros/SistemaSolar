package br.com.dasare.solarOffGrid.entity;


import jakarta.persistence.*;

@Entity
public class SolarPainel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marcaSolarPainel;
    Double pvModuleEfficiency;
    String pvType;
    Double openCircuitVoltage;
    Double optimumOperatingVoltageVmp;
    Double shortCircuitCurrentIsc;
    Double optimumOperatingCurrentImp;
    Double maximumPoweratStcPmax;
    String operatingTemperature;
    String nominalOperatingCellTemperature;
    Double tempCoefficientofPmax;
    Double tempCoefficientofVoc;
    Double tempCoefficientofIsc;

    public SolarPainel() {
    }

    public SolarPainel(String marcaSolarPainel,
                       Double pvModuleEfficiency, String pvType,
                       Double openCircuitVoltage, Double optimumOperatingVoltageVmp,
                       Double shortCircuitCurrentIsc, Double optimumOperatingCurrentImp,
                       Double maximumPoweratStcPmax, String operatingTemperature,
                       String nominalOperatingCellTemperature, Double tempCoefficientofPmax,
                       Double tempCoefficientofVoc, Double tempCoefficientofIsc) {
        this.marcaSolarPainel = marcaSolarPainel;
        this.pvModuleEfficiency = pvModuleEfficiency;
        this.pvType = pvType;
        this.openCircuitVoltage = openCircuitVoltage;
        this.optimumOperatingVoltageVmp = optimumOperatingVoltageVmp;
        this.shortCircuitCurrentIsc = shortCircuitCurrentIsc;
        this.optimumOperatingCurrentImp = optimumOperatingCurrentImp;
        this.maximumPoweratStcPmax = maximumPoweratStcPmax;
        this.operatingTemperature = operatingTemperature;
        this.nominalOperatingCellTemperature = nominalOperatingCellTemperature;
        this.tempCoefficientofPmax = tempCoefficientofPmax;
        this.tempCoefficientofVoc = tempCoefficientofVoc;
        this.tempCoefficientofIsc = tempCoefficientofIsc;
    }

    public Long getId() {
        return id;
    }

    public String getMarcaSolarPainel() {
        return marcaSolarPainel;
    }

    public void setMarcaSolarPainel(String marcaSolarPainel) {
        this.marcaSolarPainel = marcaSolarPainel;
    }

    public Double getPvModuleEfficiency() {
        return pvModuleEfficiency;
    }

    public void setPvModuleEfficiency(Double pvModuleEfficiency) {
        this.pvModuleEfficiency = pvModuleEfficiency;
    }

    public String getPvType() {
        return pvType;
    }

    public void setPvType(String pvType) {
        this.pvType = pvType;
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

    public Double getMaximumPoweratStcPmax() {
        return maximumPoweratStcPmax;
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

    public void setMaximumPoweratStcPmax(Double maximumPoweratStcPmax) {
        this.maximumPoweratStcPmax = maximumPoweratStcPmax;
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
