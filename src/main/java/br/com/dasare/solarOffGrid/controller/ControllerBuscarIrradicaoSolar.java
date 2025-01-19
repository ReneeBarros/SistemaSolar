package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.dto.response.ResponseIrradiacaoSolar;
import br.com.dasare.solarOffGrid.repository.LocalizacaoCidadeRepository;
import br.com.dasare.solarOffGrid.service.solarsistem.IrradiacaoSolarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/irradicao-solar")
public class ControllerBuscarIrradicaoSolar {
    private final IrradiacaoSolarService service;

    public ControllerBuscarIrradicaoSolar(IrradiacaoSolarService service) {
        this.service = service;
    }


    @GetMapping("/bring-irradiacao-solar-by-ciade/{cidade}")
    public ResponseEntity<ResponseIrradiacaoSolar> buscarIrradiacaoSolarByLocation(@PathVariable String cidade){
       return ResponseEntity.status(HttpStatus.FOUND).body(service.buscarIrradiacaoSolarByLocation(cidade));
    }
}
