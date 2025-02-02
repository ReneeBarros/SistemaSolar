package br.com.dasare.solarOffGrid.repository;

import br.com.dasare.solarOffGrid.entity.FatorCorrecaoInclinacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FatorCorrecaoRepository extends JpaRepository<FatorCorrecaoInclinacao,Long> {

    @Query("SELECT i FROM FatorCorrecaoInclinacao i WHERE i.latitude = ?1")
    Optional<FatorCorrecaoInclinacao> findInversorByPower(@Param("power") Double power);


}
