package br.com.dasare.solarOffGrid.controller;


import br.com.dasare.solarOffGrid.service.calculatebattery.battery.CalculateBaterryBank;
import br.com.dasare.solarOffGrid.service.request.RequestBaterryBank;
import br.com.dasare.solarOffGrid.service.response.ResponseBaterryBank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/batterybank")
public class ControllerBaterryBank {

    private final CalculateBaterryBank batteryService;

    public ControllerBaterryBank(CalculateBaterryBank battery) {
        this.batteryService = battery;
    }


    @PostMapping("/battery")
    ResponseEntity<ResponseBaterryBank> baterryBank(@RequestBody RequestBaterryBank request){

        return ResponseEntity.status(HttpStatus.OK).body(batteryService.baterryBank(request));
    }

}
