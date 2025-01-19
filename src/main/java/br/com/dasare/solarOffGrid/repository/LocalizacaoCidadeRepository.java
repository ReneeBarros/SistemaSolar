package br.com.dasare.solarOffGrid.repository;


import br.com.dasare.solarOffGrid.entity.InversorOngrid;
import br.com.dasare.solarOffGrid.entity.LocalizacaoCidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalizacaoCidadeRepository extends JpaRepository<LocalizacaoCidade, Long> {


    @Query("SELECT m FROM LocalizacaoCidade m WHERE m.munUf = ?1")
    Optional<LocalizacaoCidade> findInversorByCidade(@Param("cidade") String cidade);


}
