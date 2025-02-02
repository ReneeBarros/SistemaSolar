package br.com.dasare.solarOffGrid.dto.request;

public record RequestOnGrid(

    String cidade,
    Double eficiencia,
    Double consumoDiarioEquip,
    Double jan,
    Double fev,
    Double mar,
    Double abl,
    Double mai,
    Double jun,
    Double jul,
    Double ago,
    Double set,
    Double out,
    Double nov,
    Double dez

) {

}
