package com.ucr.smas.repository;

import com.ucr.smas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}
