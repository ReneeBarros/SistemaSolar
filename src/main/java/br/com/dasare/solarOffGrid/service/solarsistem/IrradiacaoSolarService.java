package br.com.dasare.solarOffGrid.service.solarsistem;

import br.com.dasare.solarOffGrid.domain.offgrid.irradiacao_solar.BuscarIrradicaoSolar;
import br.com.dasare.solarOffGrid.dto.response.ResponseIrradiacaoSolar;
import br.com.dasare.solarOffGrid.entity.IrradiacaoSolar;
import br.com.dasare.solarOffGrid.entity.LocalizacaoCidade;
import br.com.dasare.solarOffGrid.mapper.IrradiacaoSolarMapper;
import br.com.dasare.solarOffGrid.repository.IrradiacaoSolarRepository;
import br.com.dasare.solarOffGrid.repository.LocalizacaoCidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IrradiacaoSolarService {

    private final IrradiacaoSolarRepository repository;
    private final LocalizacaoCidadeRepository cidadeRepository;
    private final BuscarIrradicaoSolar buscarIrradicaoSolar;



    public IrradiacaoSolarService(IrradiacaoSolarRepository repository, LocalizacaoCidadeRepository cidadeRepository, BuscarIrradicaoSolar buscarIrradicaoSolar) {
        this.repository = repository;
        this.cidadeRepository = cidadeRepository;
        this.buscarIrradicaoSolar = buscarIrradicaoSolar;
    }

    public ResponseIrradiacaoSolar buscarIrradiacaoSolarByLocation(String cidade){
         LocalizacaoCidade location = cidadeRepository.findLocationByCidade(cidade.toUpperCase()).get();

        List<IrradiacaoSolar> logitude = repository.findAll();
       // IrradiacaoSolar coodenada = new BuscarIrradicaoSolar().encontrarInrradiacao(location, logitude);
        IrradiacaoSolar locationCity =  buscarIrradicaoSolar.encontrarCoordenadaMaisProxima(logitude,location.getLatitude(), location.getLongitude());

        assert locationCity != null;
        return new IrradiacaoSolarMapper().entityToResponse(locationCity);
    }

    public Double encontrarMenorIrradiacao(ResponseIrradiacaoSolar irrSolar){
       return buscarIrradicaoSolar.encontrarMenorIrradiacao(irrSolar);

    }


}
