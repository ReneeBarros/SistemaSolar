package br.com.dasare.solarOffGrid.repository;


import br.com.dasare.solarOffGrid.entity.InversorOffGridEntity;
import br.com.dasare.solarOffGrid.entity.InversorOngrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InversorOffgridRepository extends JpaRepository<InversorOffGridEntity, Long> {

    @Query("SELECT a FROM InversorOffGridEntity a WHERE a.potenciaSaidaNorminal = ?1")
    Optional<InversorOffGridEntity> findInversorByPower(@Param("power") Integer power);

}
