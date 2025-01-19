package br.com.dasare.solarOffGrid.service;


import br.com.dasare.solarOffGrid.dto.request.RequestSolarSistemYield;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemYield;
import br.com.dasare.solarOffGrid.service.solarsistem.IrradiacaoSolarService;
import org.springframework.stereotype.Service;

@Service
public class SistemYieldService {


    private final IrradiacaoSolarService service;


    public SistemYieldService(IrradiacaoSolarService service) {
        this.service = service;
    }


    public ResponseSistemYield calcularROI(

            RequestSolarSistemYield request
    ) {

        // 1. Estima a geração diária, mensal e anual de energia (em kWh)
        double irradiacaoSolarDiaria = service.buscarIrradiacaoSolarByLocation(request.city()).mediaAnual();
        double potenciaTotalSistema = request.sistemPowerGeneration(); // Potência total do sistema em W
        double energiaDiariaGerada = potenciaTotalSistema * irradiacaoSolarDiaria * request.sistemEfficiency() / 1000; // kWh/dia
        double energiaMensalGerada = energiaDiariaGerada * 30; // kWh/mês
        double energiaAnualGerada = energiaDiariaGerada * 365; // kWh/ano

        // 2. Calcula a porcentagem do consumo atendida pelo sistema solar
        double percentualAtendimentoMensal = (energiaMensalGerada / request.monthlyEnergyConsumption()) * 100;

        // 3. Calcula o valor da economia mensal e Anual
        double economiaMensal = energiaMensalGerada * request.priceKWh(); // R$/mês
        var economiaAnual = getEconomiaAnual(request, energiaAnualGerada);
        double economiaAnualMedia = economiaAnual / request.years();


        // 4. Calcula a redução mensal e anual de emissões de CO₂
        double reducaoDiariaCO2 = energiaDiariaGerada * 0.084 / 1000; // Toneladas/dia
        double reducaoMensalCO2 = reducaoDiariaCO2 * 30; // Toneladas/mês
        double reducaoAnualCO2 = reducaoDiariaCO2 * 365; // Toneladas/ano

        // 5. Calcula o ROI e o retorno múltiplo
        double roi = request.initialInvestiment() / economiaAnualMedia;
        double retornoMultiplo = economiaAnual / request.initialInvestiment();

   /*     // Exibe os resultados detalhados
        System.out.println("\n--- Resultados ---");
        System.out.printf("Potência total do sistema: %.2f W\n", potenciaTotalSistema);
        System.out.printf("Energia gerada diariamente: %.2f kWh\n", energiaDiariaGerada);
        System.out.printf("Energia gerada mensalmente: %.2f kWh\n", energiaMensalGerada);
        System.out.printf("Energia gerada anualmente: %.2f kWh\n", energiaAnualGerada);
        System.out.printf("O sistema solar atende %.2f%% do consumo médio mensal\n", percentualAtendimentoMensal);
        System.out.printf("Economia mensal inicial: R$ %.2f\n", economiaMensal);
        System.out.printf("Economia anual média (com reajustes): R$ %.2f\n", economiaAnualMedia);
        System.out.printf("Redução mensal de emissões de CO₂: %.4f toneladas\n", reducaoMensalCO2);
        System.out.printf("Redução anual de emissões de CO₂: %.4f toneladas\n", reducaoAnualCO2);
        System.out.printf("Retorno sobre o investimento (ROI): %.2f anos\n", roi);
        System.out.printf("O investimento será recuperado %.2f vezes em %d anos\n", retornoMultiplo, anos);
        System.out.printf("Economia acumulada em %d anos (após manutenção): R$ %.2f\n", anos, economiaAnual);*/

        return new ResponseSistemYield(
            request.city(),
            request.priceKWh(),
            request.initialInvestiment(),
            request.sistemPowerGeneration(),
            request.monthlyEnergyConsumption(),
            request.sistemEfficiency(),
            request.annualMaintaenanceCost(),
            request.annualAdjsutmentTarifaEnergy(),
            request.years(),
            irradiacaoSolarDiaria,
            Double.valueOf(String.format("%.2f",energiaDiariaGerada).replace(",",".")),
            Double.valueOf(String.format("%.2f",energiaMensalGerada).replace(",",".")),
            Double.valueOf(String.format("%.2f",energiaAnualGerada).replace(",",".")),
            Double.valueOf(String.format("%.2f",percentualAtendimentoMensal).replace(",",".")),
            Double.valueOf(String.format("%.2f",economiaMensal).replace(",",".")),
            Double.valueOf(String.format("%.2f",economiaAnualMedia).replace(",",".")),
            Double.valueOf(String.format("%.2f",roi).replace(",",".")),
            Double.valueOf(String.format("%.2f",retornoMultiplo).replace(",",".")),
            Double.valueOf(String.format("%.2f",economiaAnual).replace(",",".")),
            Double.valueOf(String.format("%.4f",reducaoDiariaCO2).replace(",",".")),
            Double.valueOf(String.format("%.4f",reducaoMensalCO2).replace(",",".")),
            Double.valueOf(String.format("%.4f",reducaoAnualCO2).replace(",","."))
    );
    }

    private double getEconomiaAnual(RequestSolarSistemYield request,double energiaAnualGerada ) {

        // 3. Calcula o valor da economia anual
        double economiaAnual = 0; // Inicializado para calcular com reajustes tarifários
        double tarifaAtual = request.priceKWh();

        for (int i = 1; i <= request.years(); i++) {
            double economiaAnoCorrente = energiaAnualGerada * tarifaAtual - request.annualMaintaenanceCost();
            economiaAnual += economiaAnoCorrente;
            tarifaAtual *= (1 + request.annualAdjsutmentTarifaEnergy() / 100);
        }
        return economiaAnual;
    }

}
