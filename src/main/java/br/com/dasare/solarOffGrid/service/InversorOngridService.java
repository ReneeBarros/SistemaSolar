package br.com.dasare.solarOffGrid.service;


import br.com.dasare.solarOffGrid.dto.request.RequestInversorOngrid;
import br.com.dasare.solarOffGrid.dto.response.ResponseInversorOngrid;
import br.com.dasare.solarOffGrid.mapper.InversorOnGridMapper;
import br.com.dasare.solarOffGrid.repository.InversorOngridRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InversorOngridService {

    private final InversorOngridRepository repository;

    public InversorOngridService(InversorOngridRepository repository) {
        this.repository = repository;
    }

    public String saveInversor(RequestInversorOngrid request){
        try{
            repository.save(new InversorOnGridMapper().requestInversorToInversorEntity(request));
            return "Salvo com Sucesso!";
        }catch (Exception e){
            return "Erro Ao Salvar " + e.getMessage();
        }
    }

    public List<ResponseInversorOngrid> bringAll(){
       return new InversorOnGridMapper().listOfInversorToListOfResponseInversor(repository.findAll()) ;

    }

    public Double MininuinvesorPower(Double totalLoad) {
        return totalLoad * 1.43 ;
    }

    public Double MaxinvesorPower(Double totalLoad) {
        return totalLoad * 2.0;
    }

}
