package br.com.dasare.solarOffGrid.service.ongrid;

import br.com.dasare.solarOffGrid.dto.request.RequestOnGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseIrradiacaoSolar;
import br.com.dasare.solarOffGrid.dto.response.ResponseIrradicaoCorrrigida;
import br.com.dasare.solarOffGrid.dto.response.ResponseSistemSolarOnGrid;
import br.com.dasare.solarOffGrid.entity.FatorCorrecaoInclinacao;
import br.com.dasare.solarOffGrid.repository.FatorCorrecaoRepository;
import br.com.dasare.solarOffGrid.repository.LocalizacaoCidadeRepository;
import br.com.dasare.solarOffGrid.service.InversorOngridService;
import br.com.dasare.solarOffGrid.service.solarsistem.IrradiacaoSolarService;
import br.com.dasare.solarOffGrid.service.solarsistem.PlacaSolarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CalculateSolarSistemOnGridService {

    private final IrradiacaoSolarService irradSolarService;
    private final LocalizacaoCidadeRepository cityLocation;
    private final FatorCorrecaoRepository fatorRepository;
    private final PlacaSolarService placaSolarService;
    private final InversorOngridService inversorOngridService;

    public CalculateSolarSistemOnGridService(IrradiacaoSolarService irradSolarService, LocalizacaoCidadeRepository cityLocation, FatorCorrecaoRepository fatorRepository, PlacaSolarService placaSolarService, InversorOngridService inversorOngridService) {
        this.irradSolarService = irradSolarService;
        this.cityLocation = cityLocation;
        this.fatorRepository = fatorRepository;
        this.placaSolarService = placaSolarService;
        this.inversorOngridService = inversorOngridService;
    }


    public Double enerngyMeDailyConsum(RequestOnGrid request){

        return (request.jan()+ request.fev()+ request.mar()+
        request.abl()+ request.mai()+ request.jun()+
        request.jul()+ request.ago()+ request.set()+
        request.out()+ request.nov()+ request.dez())/(12*30);
    }


    public Double calculateAngleIdeal(RequestOnGrid request){
        return 3.7 + 0.69 * cityLocation.findLocationByCidade(request.cidade()).get().getLatitude();
    }


    public FatorCorrecaoInclinacao encontrarFatorMaisProxima(
            double valorEntradaLatitude
    ) {

        List<FatorCorrecaoInclinacao> tabela= fatorRepository.findAll();

        if (tabela.isEmpty()) {
            return null; // Retorna nulo se a tabela estiver vazia
        }

        FatorCorrecaoInclinacao fatorMaisProximo = tabela.get(0);

        double menorDiferenca = Math.abs(valorEntradaLatitude - fatorMaisProximo.getIdentificacao());

        for (FatorCorrecaoInclinacao fator : tabela) {
            double diferencaAtual = Math.abs(valorEntradaLatitude - fator.getIdentificacao());

            if (diferencaAtual < menorDiferenca) {
                menorDiferenca = diferencaAtual;
                fatorMaisProximo = fator;
            }
        }

        return fatorMaisProximo;
    }

    public List<FatorCorrecaoInclinacao> encontrarFatoresMaisProximas(
            double valorEntradaLatitude
    ) {

        List<FatorCorrecaoInclinacao> tabela= fatorRepository.findAll();

        if (tabela.isEmpty()) {
            return null; // Retorna nulo se a tabela estiver vazia
        }

        FatorCorrecaoInclinacao maisProxima = null;
        FatorCorrecaoInclinacao maisProximaAbaixo = null;

        double menorDiferenca = Double.MAX_VALUE;
        double menorDiferencaAbaixo = Double.MAX_VALUE;

        // Percorre toda a tabela
        for (FatorCorrecaoInclinacao fator : tabela) {
            double latitudeAtual = fator.getIdentificacao();
            double diferencaAtual = Math.abs(valorEntradaLatitude - latitudeAtual);

            // Atualiza a latitude mais próxima (geral)
            if (diferencaAtual < menorDiferenca) {
                menorDiferenca = diferencaAtual;
                maisProxima = fator;
            }

            // Verifica se a latitude está abaixo da entrada e é a mais próxima abaixo
            if (latitudeAtual < valorEntradaLatitude) {
                double diferencaAbaixo = valorEntradaLatitude - latitudeAtual;
                if (diferencaAbaixo < menorDiferencaAbaixo) {
                    menorDiferencaAbaixo = diferencaAbaixo;
                    maisProximaAbaixo = fator;
                }
            }
        }

        List<FatorCorrecaoInclinacao> resultado = new ArrayList<>();

        resultado.add(maisProxima);
        resultado.add(maisProximaAbaixo);

        return resultado;
    }


    public FatorCorrecaoInclinacao buscarLatitudeAnguloInclinacao(
        RequestOnGrid request
        //double valorEntradaLatitude,
        //double valorEntradaInclinacao

    ) {

        Double _latitude = cityLocation.findLocationByCidade(request.cidade()).get().getLatitude();
        Double _angule = calculateAngleIdeal(request);

        List<FatorCorrecaoInclinacao> tabela= fatorRepository.findAll();


            if (tabela.isEmpty()) {
                return null; // Retorna nulo se a tabela estiver vazia
            }

            FatorCorrecaoInclinacao pontoMaisProximo = null;
            double menorDistancia = Double.MAX_VALUE;

            // Percorre toda a tabela
            for (FatorCorrecaoInclinacao fator : tabela) {
                double latitudeAtual = fator.getIdentificacao();
                double inclinacaoAtual = fator.getInclinacao();

                // Calcula a distância Euclidiana
                double distanciaAtual = Math.sqrt(
                        Math.pow(_latitude - latitudeAtual, 2) +
                                Math.pow(_angule - inclinacaoAtual, 2)
                );

                // Atualiza o ponto mais próximo se a distância for menor
                if (distanciaAtual < menorDistancia) {
                    menorDistancia = distanciaAtual;
                    pontoMaisProximo = fator;
                }
            }

            return pontoMaisProximo;
    }

    public ResponseIrradicaoCorrrigida correcaoIrradiacaoByFator(RequestOnGrid request){

      ResponseIrradiacaoSolar irradiacao =   irradSolarService.buscarIrradiacaoSolarByLocation(request.cidade());
      FatorCorrecaoInclinacao fatorCorrecao = buscarLatitudeAnguloInclinacao(request);

        Double mediaCorrigida =
                ((irradiacao.janeiro() * fatorCorrecao.getJan())+
                (irradiacao.fervereiro() * fatorCorrecao.getFev())+
                (irradiacao.marco() * fatorCorrecao.getMar())+
                (irradiacao.abril() * fatorCorrecao.getAbr())+
                (irradiacao.maio() * fatorCorrecao.getMai())+
                (irradiacao.junho() * fatorCorrecao.getJun())+
                (irradiacao.julho() * fatorCorrecao.getJul())+
                (irradiacao.agosto() * fatorCorrecao.getAgo())+
                (irradiacao.setembro() * fatorCorrecao.getSett())+
                (irradiacao.outubro() * fatorCorrecao.getOut())+
                (irradiacao.novembro() * fatorCorrecao.getNov())+
                (irradiacao.dezembro() * fatorCorrecao.getDez()) )/12;


        return new ResponseIrradicaoCorrrigida(
                mediaCorrigida,
                (irradiacao.janeiro() * fatorCorrecao.getJan()),
                (irradiacao.fervereiro() * fatorCorrecao.getFev()),
                (irradiacao.marco() * fatorCorrecao.getMar()),
                (irradiacao.abril() * fatorCorrecao.getAbr()),
                (irradiacao.maio() * fatorCorrecao.getMai()),
                (irradiacao.junho() * fatorCorrecao.getJun()),
                (irradiacao.julho() * fatorCorrecao.getJul()),
                (irradiacao.agosto() * fatorCorrecao.getAgo()),
                (irradiacao.setembro() * fatorCorrecao.getSett()),
                (irradiacao.outubro() * fatorCorrecao.getOut()),
                (irradiacao.novembro() * fatorCorrecao.getNov()),
                (irradiacao.dezembro() * fatorCorrecao.getDez())
        );
    }

    public ResponseSistemSolarOnGrid calcularSitemaOnGrid(RequestOnGrid request){
        Double mediaConsumoDiario;
        if(request.consumoDiarioEquip()==0.0){
            mediaConsumoDiario = enerngyMeDailyConsum(request);
        }else{
            mediaConsumoDiario = (request.consumoDiarioEquip()/1000);
        }

        Double irradicaoMediaDiariaCorrigida = correcaoIrradiacaoByFator(request).mediaAnual();
        Double eficienciaSistema=request.eficiencia();
        Double potenciaTotalSistema= mediaConsumoDiario/(irradicaoMediaDiariaCorrigida*(eficienciaSistema/100));
        List<Double> potenciaPlaca = new ArrayList<>();
        List<Double> numeroPlacaCalculado = new ArrayList<>();
        Double potenciaMinimaInversor = inversorOngridService.MininuinvesorPower((potenciaTotalSistema));
        Double potenciaMaximaInversor= inversorOngridService.MaxinvesorPower(potenciaTotalSistema);
        Map<Double, Double> numeroPlacaSolar = placaSolarService.calcularPlacarSolarSimples(potenciaTotalSistema*1000);
        for (Map.Entry<Double, Double> entrada : numeroPlacaSolar.entrySet()) {
            potenciaPlaca.add(entrada.getKey());
            numeroPlacaCalculado.add(entrada.getValue());
        }
        return new ResponseSistemSolarOnGrid(
            Double.valueOf(String.format("%.2f",mediaConsumoDiario).replace(",",".")),
            Double.valueOf(String.format("%.2f",irradicaoMediaDiariaCorrigida).replace(",",".")),
            Double.valueOf(String.format("%.2f",eficienciaSistema).replace(",",".")),
            Double.valueOf(String.format("%.2f",potenciaTotalSistema).replace(",",".")),
            potenciaPlaca,
            numeroPlacaCalculado,
            Double.valueOf(String.format("%.2f",potenciaMinimaInversor).replace(",",".")),
            Double.valueOf(String.format("%.2f",potenciaMaximaInversor).replace(",","."))
        );
    }
}
