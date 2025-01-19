package br.com.dasare.solarOffGrid.repository;

import br.com.dasare.solarOffGrid.entity.SolarPainel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolarPanelRepository extends JpaRepository<SolarPainel, Long> {

    @Query("SELECT s FROM SolarPainel s WHERE s.maximumPoweratStcPmax = ?1")
    Optional<SolarPainel> findSolarPainelByPower(@Param("power") Double power);
}
