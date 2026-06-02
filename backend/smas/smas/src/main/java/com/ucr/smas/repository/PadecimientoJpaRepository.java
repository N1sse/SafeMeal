package com.ucr.smas.repository;


import com.ucr.smas.model.Padecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadecimientoJpaRepository extends JpaRepository<Padecimiento, Integer> {

    Padecimiento getById(Integer id);

    Padecimiento getByNombre(String nombre);


}
