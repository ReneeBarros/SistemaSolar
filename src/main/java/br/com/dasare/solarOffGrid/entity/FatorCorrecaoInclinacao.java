package br.com.dasare.solarOffGrid.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "FATOR_CORRECAO")
public class FatorCorrecaoInclinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double latitude;
    Double identificacao;
    Double inclinacao;
    Double jan;
    Double fev;
    Double mar;
    Double abr;
    Double mai;
    Double jun;
    Double jul;
    Double ago;
    Double sett;
    Double out;
    Double nov;
    Double dez;

    public FatorCorrecaoInclinacao() {
    }

    public FatorCorrecaoInclinacao(Long id, Double latitude, Double identificacao, Double inclinacao, Double jan, Double fev, Double mar, Double abr,
                                   Double mai, Double jun, Double jul, Double ago, Double sett, Double out, Double nov, Double dez) {
        this.id = id;
        this.latitude = latitude;
        this.identificacao = identificacao;
        this.inclinacao = inclinacao;
        this.jan = jan;
        this.fev = fev;
        this.mar = mar;
        this.abr = abr;
        this.mai = mai;
        this.jun = jun;
        this.jul = jul;
        this.ago = ago;
        this.sett = sett;
        this.out = out;
        this.nov = nov;
        this.dez = dez;
    }

    public Double getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Double identificacao) {
        this.identificacao = identificacao;
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

    public Double getInclinacao() {
        return inclinacao;
    }

    public void setInclinacao(Double inclinacao) {
        this.inclinacao = inclinacao;
    }

    public Double getJan() {
        return jan;
    }

    public void setJan(Double jan) {
        this.jan = jan;
    }

    public Double getFev() {
        return fev;
    }

    public void setFev(Double fev) {
        this.fev = fev;
    }

    public Double getMar() {
        return mar;
    }

    public void setMar(Double mar) {
        this.mar = mar;
    }

    public Double getAbr() {
        return abr;
    }

    public void setAbr(Double abr) {
        this.abr = abr;
    }

    public Double getMai() {
        return mai;
    }

    public void setMai(Double mai) {
        this.mai = mai;
    }

    public Double getJun() {
        return jun;
    }

    public void setJun(Double jun) {
        this.jun = jun;
    }

    public Double getJul() {
        return jul;
    }

    public void setJul(Double jul) {
        this.jul = jul;
    }

    public Double getAgo() {
        return ago;
    }

    public void setAgo(Double ago) {
        this.ago = ago;
    }

    public Double getSett() {
        return sett;
    }

    public void setSett(Double sett) {
        this.sett = sett;
    }

    public Double getOut() {
        return out;
    }

    public void setOut(Double out) {
        this.out = out;
    }

    public Double getNov() {
        return nov;
    }

    public void setNov(Double nov) {
        this.nov = nov;
    }

    public Double getDez() {
        return dez;
    }

    public void setDez(Double dez) {
        this.dez = dez;
    }
}
