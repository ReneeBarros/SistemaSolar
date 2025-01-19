package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestInversorOngrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversorOngrid;
import br.com.dasare.solarOffGrid.service.InversorOngridService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inversor")
public class ControllerInversorOngrid {

    private final InversorOngridService service;


    public ControllerInversorOngrid(InversorOngridService service) {
        this.service = service;
    }

    @PostMapping("/save-inversor")
    public ResponseEntity<String> saveInversor(@RequestBody RequestInversorOngrid request){
        return ResponseEntity.status(HttpStatus.OK).body(service.saveInversor(request));
    }

    @GetMapping()
    public ResponseEntity<List<ResponseInversorOngrid>>bringAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.bringAll());
    }

}
