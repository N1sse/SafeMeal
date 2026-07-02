package com.ucr.smas.repository;

import com.ucr.smas.model.PlanComidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlanComidasJpaRepository extends JpaRepository<PlanComidas, Integer> {
    PlanComidas getById(Integer id);

    // Planes de comida
    List<PlanComidas> findByUser_Id(Integer userId);
}
