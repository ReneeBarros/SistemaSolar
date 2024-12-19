package br.com.dasare.solarOffGrid.service;


import br.com.dasare.solarOffGrid.repository.InversorRepository;
import org.springframework.stereotype.Service;

@Service
public class InversorService {

    private final InversorRepository repository;

    public InversorService(InversorRepository repository) {
        this.repository = repository;
    }

}
