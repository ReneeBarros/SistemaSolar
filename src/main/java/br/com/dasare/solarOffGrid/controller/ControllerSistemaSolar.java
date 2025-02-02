package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestCalculateSistemSolarComplete;
import br.com.dasare.solarOffGrid.dto.request.RequestOnGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemSolarOnGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemSolarOffGridComplete;
import br.com.dasare.solarOffGrid.service.ongrid.CalculateSolarSistemOnGridService;
import br.com.dasare.solarOffGrid.service.solarsistem.CalculateSolarSistemOffGridService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/solarsistem")
public class ControllerSistemaSolar {

    private final CalculateSolarSistemOffGridService service;
    private final CalculateSolarSistemOnGridService oNgridSistemService;


    public ControllerSistemaSolar(CalculateSolarSistemOffGridService service, CalculateSolarSistemOnGridService oNgridSistemService) {
        this.service = service;
        this.oNgridSistemService = oNgridSistemService;
    }

    @PostMapping("/sistem-offgrid")
    ResponseEntity<ResponseSistemSolarOffGridComplete> sistemOffGrid(@RequestBody RequestCalculateSistemSolarComplete request){
        return ResponseEntity.status(HttpStatus.OK).body(service.calculateSitemSolarComplete(request));
    }

    @PostMapping("/sistem-ongrid")
    ResponseEntity<ResponseSistemSolarOnGrid> sistemOnGrid(@RequestBody RequestOnGrid request){
        return ResponseEntity.status(HttpStatus.OK).body(oNgridSistemService.calcularSitemaOnGrid(request));
    }

}
