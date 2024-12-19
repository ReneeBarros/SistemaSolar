package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.request.RequestCalculateSistemSolarComplete;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversor;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemSolarComplete;
import br.com.dasare.solarOffGrid.mapper.InversorMapper;
import br.com.dasare.solarOffGrid.repository.InversorRepository;
import br.com.dasare.solarOffGrid.service.solarpainels.CalculateSolarPanelsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/CompleteSistem")
public class ControllerSistemaSolar {

    private final CalculateSolarPanelsService service;
    private final InversorRepository repository;

    public ControllerSistemaSolar(CalculateSolarPanelsService service, InversorRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/solarsistem")
    ResponseEntity<ResponseSistemSolarComplete> baterryBank(@RequestBody RequestCalculateSistemSolarComplete request){
        return ResponseEntity.status(HttpStatus.OK).body(service.calculateSitemSolarComplete(request));
    }

    @GetMapping("/findall_inversor")
    ResponseEntity<List<ResponseInversor>> findAllInversor(){
        return ResponseEntity.status(HttpStatus.OK).body(new InversorMapper().listOfInversorToListOfResponseInversor(repository.findAll()));
    }

    @PostMapping("/find-by-inversor-power")
    ResponseEntity<ResponseInversor> findbyInversorpower(@RequestBody Double power){
        return ResponseEntity.status(HttpStatus.OK).body(new InversorMapper().inversorToResponseInversor(repository.findInversorByPower(power).get()));
    }

}
