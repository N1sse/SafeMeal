package com.ucr.smas.repository;

import com.ucr.smas.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentoJpaRepository extends JpaRepository<Alimento, Integer> {

    // Todos los alimentos del catálogo para un conjunto de padecimientos.
    List<Alimento> findByPadecimiento_IdIn(List<Integer> padecimientoIds);

    // Alimentos del catálogo para un único padecimiento.
    List<Alimento> findByPadecimiento_Id(Integer padecimientoId);
}
