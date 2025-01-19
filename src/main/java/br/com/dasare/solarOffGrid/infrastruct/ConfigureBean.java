package br.com.dasare.solarOffGrid.infrastruct;


import br.com.dasare.solarOffGrid.domain.offgrid.impl.CaculateBatteryBankImpl;
import br.com.dasare.solarOffGrid.domain.offgrid.impl.CalculateSolarPainelImpls;
import br.com.dasare.solarOffGrid.domain.offgrid.impl.OffGridCalculateImpl;
import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateBatteryBankInterface;
import br.com.dasare.solarOffGrid.domain.offgrid.interfac.CalculateSolarPainelIntefarce;
import br.com.dasare.solarOffGrid.domain.offgrid.interfac.OffGridCalculateInterface;
import br.com.dasare.solarOffGrid.domain.offgrid.irradiacao_solar.BuscarIrradicaoSolar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureBean {

    @Bean
    OffGridCalculateInterface offGridCalculateInterface(){
        return new OffGridCalculateImpl() {
        };
    }

    @Bean
    CalculateBatteryBankInterface calculateBatteryBankInterface(){
        return new CaculateBatteryBankImpl();
    }

    @Bean
    CalculateSolarPainelIntefarce calculateSolarPainelIntefarce(){
        return new CalculateSolarPainelImpls();
    }

    @Bean
    BuscarIrradicaoSolar buscarIrradicaoSolar(){return new BuscarIrradicaoSolar();}

}
