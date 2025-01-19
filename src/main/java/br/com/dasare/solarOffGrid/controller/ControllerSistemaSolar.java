package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestCalculateSistemSolarComplete;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversorOngrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemSolarComplete;
import br.com.dasare.solarOffGrid.mapper.InversorOnGridMapper;
import br.com.dasare.solarOffGrid.repository.InversorOngridRepository;
import br.com.dasare.solarOffGrid.service.solarsistem.CalculateSolarSistemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/solarsistem")
public class ControllerSistemaSolar {

    private final CalculateSolarSistemService service;

    public ControllerSistemaSolar(CalculateSolarSistemService service) {
        this.service = service;
    }

    @PostMapping("/sistem-offgrid")
    ResponseEntity<ResponseSistemSolarComplete> sistemOffGrid(@RequestBody RequestCalculateSistemSolarComplete request){
        return ResponseEntity.status(HttpStatus.OK).body(service.calculateSitemSolarComplete(request));
    }

}
