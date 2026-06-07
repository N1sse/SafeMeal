package com.ucr.smas.repository;

import com.ucr.smas.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuJpaRepository extends JpaRepository<Menu, Integer> {
    Menu getById(Integer id);
}
