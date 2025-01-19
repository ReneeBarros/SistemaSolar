package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestSolarSistemYield;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemYield;
import br.com.dasare.solarOffGrid.service.SistemYieldService;
import br.com.dasare.solarOffGrid.service.solarsistem.PlacaSolarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ControllerSistemYield {

    private final SistemYieldService service;

    public ControllerSistemYield(SistemYieldService service) {
        this.service = service;
    }

    @PostMapping("/SistemYield")
    public ResponseEntity<ResponseSistemYield> energyProdtion(@RequestBody RequestSolarSistemYield request){
        return ResponseEntity.status(HttpStatus.OK).body(service.calcularROI(request));
    }
}
