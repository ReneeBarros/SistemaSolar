package br.com.dasare.solarOffGrid.repository;


import br.com.dasare.solarOffGrid.entity.Inversor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InversorRepository extends JpaRepository<Inversor, Long> {


    @Query("SELECT a FROM Inversor a WHERE a.potenciaMaxAcSaida = ?1")
   Optional<Inversor> findInversorByPower(@Param("power") Double power);

}
