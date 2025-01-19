package br.com.dasare.solarOffGrid.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_inversor_offgrid")
public class InversorOffGridEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marca;
    Double tensaoNorminalEntrada;
    Integer potenciaSaidaNorminal;
    Integer potenciaSaidaPico;
    Integer tensaoNorminalSaida;
    String formaOnda;
    String frequenciasaida;
    Double eficienciaInversor;
    String dimensao;

    public InversorOffGridEntity() {
    }

    public InversorOffGridEntity(String marca, Double tensaoNorminalEntrada, Integer potenciaSaidaNorminal, Integer potenciaSaidaPico, Integer tensaoNorminalSaida, String formaOnda, String frequenciasaida, Double eficienciaInversor, String dimensao) {
        this.marca = marca;
        this.tensaoNorminalEntrada = tensaoNorminalEntrada;
        this.potenciaSaidaNorminal = potenciaSaidaNorminal;
        this.potenciaSaidaPico = potenciaSaidaPico;
        this.tensaoNorminalSaida = tensaoNorminalSaida;
        this.formaOnda = formaOnda;
        this.frequenciasaida = frequenciasaida;
        this.eficienciaInversor = eficienciaInversor;
        this.dimensao = dimensao;
    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getTensaoNorminalEntrada() {
        return tensaoNorminalEntrada;
    }

    public void setTensaoNorminalEntrada(Double tensaoNorminalEntrada) {
        this.tensaoNorminalEntrada = tensaoNorminalEntrada;
    }

    public Integer getPotenciaSaidaNorminal() {
        return potenciaSaidaNorminal;
    }

    public void setPotenciaSaidaNorminal(Integer potenciaSaidaNorminal) {
        this.potenciaSaidaNorminal = potenciaSaidaNorminal;
    }

    public Integer getPotenciaSaidaPico() {
        return potenciaSaidaPico;
    }

    public void setPotenciaSaidaPico(Integer potenciaSaidaPico) {
        this.potenciaSaidaPico = potenciaSaidaPico;
    }

    public Integer getTensaoNorminalSaida() {
        return tensaoNorminalSaida;
    }

    public void setTensaoNorminalSaida(Integer tensaoNorminalSaida) {
        this.tensaoNorminalSaida = tensaoNorminalSaida;
    }

    public String getFormaOnda() {
        return formaOnda;
    }

    public void setFormaOnda(String formaOnda) {
        this.formaOnda = formaOnda;
    }

    public String getFrequenciasaida() {
        return frequenciasaida;
    }

    public void setFrequenciasaida(String frequenciasaida) {
        this.frequenciasaida = frequenciasaida;
    }

    public Double getEficienciaInversor() {
        return eficienciaInversor;
    }

    public void setEficienciaInversor(Double eficienciaInversor) {
        this.eficienciaInversor = eficienciaInversor;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InversorOffGridEntity that = (InversorOffGridEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
