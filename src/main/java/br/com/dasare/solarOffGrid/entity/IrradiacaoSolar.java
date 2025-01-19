package br.com.dasare.solarOffGrid.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IrradiacaoSolar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double latitude;
    Double longitude;
    Double mediaAnual;
    Double janeiro;
    Double fervereiro;
    Double marco;
    Double abril;
    Double maio;
    Double junho;
    Double julho;
    Double agosto;
    Double setembro;
    Double outubro;
    Double novembro;
    Double dezembro;

    public IrradiacaoSolar() {
    }

    public IrradiacaoSolar(Double latitude, Double longitude, Double mediaAnual, Double janeiro, Double fervereiro, Double marco, Double abril, Double maio, Double junho, Double julho,
                           Double agosto, Double setembro, Double outubro, Double novembro, Double dezembro) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.mediaAnual = mediaAnual;
        this.janeiro = janeiro;
        this.fervereiro = fervereiro;
        this.marco = marco;
        this.abril = abril;
        this.maio = maio;
        this.junho = junho;
        this.julho = julho;
        this.agosto = agosto;
        this.setembro = setembro;
        this.outubro = outubro;
        this.novembro = novembro;
        this.dezembro = dezembro;
    }

    public Long getId() {
        return id;
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

    public Double getMediaAnual() {
        return mediaAnual;
    }

    public void setMediaAnual(Double mediaAnual) {
        this.mediaAnual = mediaAnual;
    }

    public Double getJaneiro() {
        return janeiro;
    }

    public void setJaneiro(Double janeiro) {
        this.janeiro = janeiro;
    }

    public Double getFervereiro() {
        return fervereiro;
    }

    public void setFervereiro(Double fervereiro) {
        this.fervereiro = fervereiro;
    }

    public Double getMarco() {
        return marco;
    }

    public void setMarco(Double marco) {
        this.marco = marco;
    }

    public Double getAbril() {
        return abril;
    }

    public void setAbril(Double abril) {
        this.abril = abril;
    }

    public Double getMaio() {
        return maio;
    }

    public void setMaio(Double maio) {
        this.maio = maio;
    }

    public Double getJunho() {
        return junho;
    }

    public void setJunho(Double junho) {
        this.junho = junho;
    }

    public Double getJulho() {
        return julho;
    }

    public void setJulho(Double julho) {
        this.julho = julho;
    }

    public Double getAgosto() {
        return agosto;
    }

    public void setAgosto(Double agosto) {
        this.agosto = agosto;
    }

    public Double getSetembro() {
        return setembro;
    }

    public void setSetembro(Double setembro) {
        this.setembro = setembro;
    }

    public Double getOutubro() {
        return outubro;
    }

    public void setOutubro(Double outubro) {
        this.outubro = outubro;
    }

    public Double getNovembro() {
        return novembro;
    }

    public void setNovembro(Double novembro) {
        this.novembro = novembro;
    }

    public Double getDezembro() {
        return dezembro;
    }

    public void setDezembro(Double dezembro) {
        this.dezembro = dezembro;
    }
}

