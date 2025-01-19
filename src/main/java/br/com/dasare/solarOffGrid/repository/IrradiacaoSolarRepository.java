package br.com.dasare.solarOffGrid.repository;


import br.com.dasare.solarOffGrid.entity.IrradiacaoSolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrradiacaoSolarRepository extends JpaRepository<IrradiacaoSolar,Long> {




}
