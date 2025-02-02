package br.com.dasare.solarOffGrid.dto.request;

import br.com.dasare.solarOffGrid.domain.Equipments;

import java.util.List;

public record RequestOffGrid(

        String city,
        List<Equipments>equipments

){}

