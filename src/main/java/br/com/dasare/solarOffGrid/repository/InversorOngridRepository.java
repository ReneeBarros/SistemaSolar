package br.com.dasare.solarOffGrid.repository;


import br.com.dasare.solarOffGrid.entity.InversorOngrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InversorOngridRepository extends JpaRepository<InversorOngrid, Long> {


    @Query("SELECT a FROM InversorOngrid a WHERE a.potenciaMaxAcSaida = ?1")
   Optional<InversorOngrid> findInversorByPower(@Param("power") Double power);

}
