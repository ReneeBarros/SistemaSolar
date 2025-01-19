package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestPlacaSolarEntity;
import br.com.dasare.solarOffGrid.dto.request.RequestSolarPanelToCalculate;
import br.com.dasare.solarOffGrid.dto.response.ResponsePlacaSolarEntity;
import br.com.dasare.solarOffGrid.dto.response.ResponseSolarPanelCalculated;
import br.com.dasare.solarOffGrid.entity.SolarPainel;
import br.com.dasare.solarOffGrid.mapper.MapperSolarPainel;
import br.com.dasare.solarOffGrid.service.solarsistem.PlacaSolarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/placa-solar")
public class ControllerPlacaSolar {

    private final PlacaSolarService service;

    public ControllerPlacaSolar(PlacaSolarService service) {
        this.service = service;
    }

    @PostMapping("/salvar-placa-solar")
    public ResponseEntity<String> save(@RequestBody RequestPlacaSolarEntity request){
        SolarPainel solarPainel = new MapperSolarPainel().requestSolarpainelToEntitySolarpainel(request);
        return ResponseEntity.status(HttpStatus.OK).body(service.salvarPlacaSolar(solarPainel));
    }

    @GetMapping("/trazer-todas-as placas")
    public ResponseEntity<List<ResponsePlacaSolarEntity>> bringAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.bringAll());
    }

    @PostMapping("/dimensionamento-painel-solar")
    public ResponseEntity<ResponseSolarPanelCalculated> calculatedSolarPanel(@RequestBody RequestSolarPanelToCalculate request){
        return ResponseEntity.status(HttpStatus.OK).body(service.calculatedSolarPanel(request));
    }

}
