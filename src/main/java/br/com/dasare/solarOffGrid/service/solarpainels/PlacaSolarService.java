package br.com.dasare.solarOffGrid.service.solarpainels;


import br.com.dasare.solarOffGrid.dto.response.ResponsePlacaSolar;
import br.com.dasare.solarOffGrid.entity.SolarPainel;
import br.com.dasare.solarOffGrid.mapper.MapperRequestToEntitySolarPainel;
import br.com.dasare.solarOffGrid.repository.SolarPanelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacaSolarService {

    private final SolarPanelRepository repository;


    public PlacaSolarService(SolarPanelRepository repository) {
        this.repository = repository;
    }

    public String salvarPlacaSolar(SolarPainel solarPainel){
        var id = repository.save(solarPainel).getMaximumPoweratSTCpmax();
        return "Painel " + id+","+" Salvo com Sucesso!";
    }

    public List<ResponsePlacaSolar> bringAll(){
        return new MapperRequestToEntitySolarPainel().placaSolarEntityListToResponsePlacaSolarList(repository.findAll());
    }
}
