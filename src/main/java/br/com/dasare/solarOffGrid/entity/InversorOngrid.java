package br.com.dasare.solarOffGrid.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_inversor_ongrid")
public class InversorOngrid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marcaInversor;
    String linhaInversor;
    String modelo;
    Double potenciaMaxEntradaCC;
    Integer tensaoCCMaxEntrada;
    Integer tensaoNorminalCCEntrada;
    Double correnteMaxEntradaPorMPPT;
    Double correnteMaxCurtoPorMPPT;
    Integer numeroMPPT;
    Integer numeroStringsMPPT;
    Double potenciaMaxAcSaida;
    String tensaoNorminalAcSaida;
    Double correnteMaxAcSaida;
    Double eficienciaMax;

    public InversorOngrid(Long id, String marcaInversor, String linhaInversor, String modelo, Double potenciaMaxEntradaCC, Integer tensaoCCMaxEntrada, Integer tensaoNorminalCCEntrada, Double correnteMaxEntradaPorMPPT, Double correnteMaxCurtoPorMPPT, Integer numeroMPPT, Integer numeroStringsMPPT, Double potenciaMaxAcSaida, String tensaoNorminalAcSaida, Double correnteMaxAcSaida, Double eficienciaMax) {
        this.id = id;
        this.marcaInversor = marcaInversor;
        this.linhaInversor = linhaInversor;
        this.modelo = modelo;
        this.potenciaMaxEntradaCC = potenciaMaxEntradaCC;
        this.tensaoCCMaxEntrada = tensaoCCMaxEntrada;
        this.tensaoNorminalCCEntrada = tensaoNorminalCCEntrada;
        this.correnteMaxEntradaPorMPPT = correnteMaxEntradaPorMPPT;
        this.correnteMaxCurtoPorMPPT = correnteMaxCurtoPorMPPT;
        this.numeroMPPT = numeroMPPT;
        this.numeroStringsMPPT = numeroStringsMPPT;
        this.potenciaMaxAcSaida = potenciaMaxAcSaida;
        this.tensaoNorminalAcSaida = tensaoNorminalAcSaida;
        this.correnteMaxAcSaida = correnteMaxAcSaida;
        this.eficienciaMax = eficienciaMax;
    }

    public InversorOngrid() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarcaInversor() {
        return marcaInversor;
    }

    public void setMarcaInversor(String marcaInversor) {
        this.marcaInversor = marcaInversor;
    }

    public String getLinhaInversor() {
        return linhaInversor;
    }

    public void setLinhaInversor(String linhaInversor) {
        this.linhaInversor = linhaInversor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPotenciaMaxEntradaCC() {
        return potenciaMaxEntradaCC;
    }

    public void setPotenciaMaxEntradaCC(Double potenciaMaxEntradaCC) {
        this.potenciaMaxEntradaCC = potenciaMaxEntradaCC;
    }

    public Integer getTensaoCCMaxEntrada() {
        return tensaoCCMaxEntrada;
    }

    public void setTensaoCCMaxEntrada(Integer tensaoCCMaxEntrada) {
        this.tensaoCCMaxEntrada = tensaoCCMaxEntrada;
    }

    public Integer getTensaoNorminalCCEntrada() {
        return tensaoNorminalCCEntrada;
    }

    public void setTensaoNorminalCCEntrada(Integer tensaoNorminalCCEntrada) {
        this.tensaoNorminalCCEntrada = tensaoNorminalCCEntrada;
    }

    public Double getCorrenteMaxEntradaPorMPPT() {
        return correnteMaxEntradaPorMPPT;
    }

    public void setCorrenteMaxEntradaPorMPPT(Double correnteMaxEntradaPorMPPT) {
        this.correnteMaxEntradaPorMPPT = correnteMaxEntradaPorMPPT;
    }

    public Double getCorrenteMaxCurtoPorMPPT() {
        return correnteMaxCurtoPorMPPT;
    }

    public void setCorrenteMaxCurtoPorMPPT(Double correnteMaxCurtoPorMPPT) {
        this.correnteMaxCurtoPorMPPT = correnteMaxCurtoPorMPPT;
    }

    public Integer getNumeroMPPT() {
        return numeroMPPT;
    }

    public void setNumeroMPPT(Integer numeroMPPT) {
        this.numeroMPPT = numeroMPPT;
    }

    public Integer getNumeroStringsMPPT() {
        return numeroStringsMPPT;
    }

    public void setNumeroStringsMPPT(Integer numeroStringsMPPT) {
        this.numeroStringsMPPT = numeroStringsMPPT;
    }

    public Double getPotenciaMaxAcSaida() {
        return potenciaMaxAcSaida;
    }

    public void setPotenciaMaxAcSaida(Double potenciaMaxAcSaida) {
        this.potenciaMaxAcSaida = potenciaMaxAcSaida;
    }

    public String getTensaoNorminalAcSaida() {
        return tensaoNorminalAcSaida;
    }

    public void setTensaoNorminalAcSaida(String tensaoNorminalAcSaida) {
        this.tensaoNorminalAcSaida = tensaoNorminalAcSaida;
    }

    public Double getCorrenteMaxAcSaida() {
        return correnteMaxAcSaida;
    }

    public void setCorrenteMaxAcSaida(Double correnteMaxAcSaida) {
        this.correnteMaxAcSaida = correnteMaxAcSaida;
    }

    public Double getEficienciaMax() {
        return eficienciaMax;
    }

    public void setEficienciaMax(Double eficienciaMax) {
        this.eficienciaMax = eficienciaMax;
    }
}
