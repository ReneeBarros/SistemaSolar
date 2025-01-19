package br.com.dasare.solarOffGrid.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LOCALIZACAO_CIDADE")
public class LocalizacaoCidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String municipio;
    String munUf;
    Double latitude;
    Double longitude;
    String uf;
    String valor;

    public LocalizacaoCidade() {
    }

    public LocalizacaoCidade(String municipio, String munUf, Double latitude, Double longitude, String uf, String valor) {
        this.municipio = municipio;
        this.munUf = munUf;
        this.latitude = latitude;
        this.longitude = longitude;
        this.uf = uf;
        this.valor = valor;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunUf() {
        return munUf;
    }

    public void setMunUf(String munUf) {
        this.munUf = munUf;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
