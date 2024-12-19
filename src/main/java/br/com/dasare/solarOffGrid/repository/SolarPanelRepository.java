package br.com.dasare.solarOffGrid.repository;

import br.com.dasare.solarOffGrid.entity.SolarPainel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarPanelRepository extends JpaRepository<SolarPainel, Long> {
}
