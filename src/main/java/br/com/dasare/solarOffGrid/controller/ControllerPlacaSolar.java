package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestPlacaSolar;
import br.com.dasare.solarOffGrid.dto.response.ResponsePlacaSolar;
import br.com.dasare.solarOffGrid.entity.SolarPainel;
import br.com.dasare.solarOffGrid.mapper.MapperRequestToEntitySolarPainel;
import br.com.dasare.solarOffGrid.repository.SolarPanelRepository;
import br.com.dasare.solarOffGrid.service.solarpainels.PlacaSolarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placa-solar")
public class ControllerPlacaSolar {

    private final PlacaSolarService service;

    public ControllerPlacaSolar(PlacaSolarService service) {
        this.service = service;
    }

    @PostMapping("/salvar-placa-solar")
    public ResponseEntity<String> save(@RequestBody RequestPlacaSolar request){
        SolarPainel solarPainel = new MapperRequestToEntitySolarPainel().requestSolarpainelToEntitySolarpainel(request);
        return ResponseEntity.status(HttpStatus.OK).body(service.salvarPlacaSolar(solarPainel));
    }

    @GetMapping("/trazer-todas-as placas")
    public ResponseEntity<List<ResponsePlacaSolar>> bringAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.bringAll());
    }

}
