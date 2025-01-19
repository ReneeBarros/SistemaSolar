package br.com.dasare.solarOffGrid.service.solarsistem;

import br.com.dasare.solarOffGrid.dto.request.RequestInversorOffGrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversorOffGrid;
import br.com.dasare.solarOffGrid.mapper.InversorOffGridMapper;
import br.com.dasare.solarOffGrid.mapper.InversorOnGridMapper;
import br.com.dasare.solarOffGrid.repository.InversorOffgridRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InversorOffGridService {

    private final InversorOffgridRepository repository;

    private InversorOffGridService(InversorOffgridRepository repository) {
        this.repository = repository;
    }

    public String saveInversorOffGrid(RequestInversorOffGrid request){

        try{
            repository.save(new InversorOffGridMapper().fromRequestToOffgridInversorEntity(request));
            return " Salvo com Sucesso!";
        }catch (Exception e){
            return "Erro ao salvar o Inversor ";
        }

    }

    public ResponseInversorOffGrid bringByPower(Integer inversorPower){
        return new InversorOffGridMapper().fromOffGridInversorEntityToResponse( repository.findInversorByPower(inversorPower).orElseThrow());
    }

    public List<ResponseInversorOffGrid> bringAllInversorOffgrid(){
        return new InversorOffGridMapper().listFromOffGridInversorEntityToResponse( repository.findAll());
    }




}
