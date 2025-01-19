package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestInversorOffGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversorOffGrid;
import br.com.dasare.solarOffGrid.service.solarsistem.InversorOffGridService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inversor-offgrid")
public class ControllerInversorOffgrid {

    private final InversorOffGridService service;


    public ControllerInversorOffgrid(InversorOffGridService service) {
        this.service = service;
    }

    @PostMapping("/save-inversor-offgrid")
    private ResponseEntity<String> saveInversor(@RequestBody RequestInversorOffGrid request){
        return ResponseEntity.status(HttpStatus.OK).body(service.saveInversorOffGrid(request));
    }

    @GetMapping("/bring-inversor-offgrid-by-power/{power}")
    private ResponseEntity<ResponseInversorOffGrid> bringInversorByPower(@PathVariable Integer power ){
        return ResponseEntity.status(HttpStatus.OK).body(service.bringByPower(power));
    }

    @GetMapping("/bring-all-inversor-offgrid")
    private ResponseEntity<List<ResponseInversorOffGrid>> bringAllInversorByPower(){
        return ResponseEntity.status(HttpStatus.OK).body(service.bringAllInversorOffgrid());
    }

}
