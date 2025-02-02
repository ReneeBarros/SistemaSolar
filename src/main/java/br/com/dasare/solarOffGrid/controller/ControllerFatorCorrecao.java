package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestOnGrid;
import br.com.dasare.solarOffGrid.entity.FatorCorrecaoInclinacao;
import br.com.dasare.solarOffGrid.service.ongrid.CalculateSolarSistemOnGridService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/fator-correcao")
public class ControllerFatorCorrecao {


    private final CalculateSolarSistemOnGridService service;

    public ControllerFatorCorrecao(CalculateSolarSistemOnGridService service) {
        this.service = service;
    }


    @PostMapping("/fator")
    ResponseEntity<FatorCorrecaoInclinacao> fatorProximo(@RequestBody Double request){
        return ResponseEntity.status(HttpStatus.OK).body(service.encontrarFatorMaisProxima(request));
    }

    @PostMapping("/fatores-mais-proximos")
    ResponseEntity<List<FatorCorrecaoInclinacao>> fatoresMaisProximos(@RequestBody Double request){
        return ResponseEntity.status(HttpStatus.OK).body(service.encontrarFatoresMaisProximas(request));
    }

    @PostMapping("/fator-by-angule")
    ResponseEntity<FatorCorrecaoInclinacao> fatoresMaisProximosByAngule(@RequestBody RequestOnGrid request){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarLatitudeAnguloInclinacao(request));
    }





}
