package br.com.dasare.solarOffGrid;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "EletricHouse", version = "2.0", description = "Dimensionamento Sistema Solar Offgrid"))
public class SolarOffGridApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolarOffGridApplication.class, args);
	}

}
