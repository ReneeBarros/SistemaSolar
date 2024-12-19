package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestOffGrid;
import br.com.dasare.solarOffGrid.service.calculatesystemload.systemload.CalculateSistemLoad;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemLoad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sistemSolar")
public class ControllerOffgridLoad {

    private final CalculateSistemLoad service;

    public ControllerOffgridLoad(CalculateSistemLoad service) {
        this.service = service;
    }

    @PostMapping("/offgrid-load")
    ResponseEntity<ResponseSistemLoad>offgridLoad(@RequestBody RequestOffGrid request ){
        return ResponseEntity.status(HttpStatus.OK).body(service.caculateSistemLoad(request) );
    }

}
