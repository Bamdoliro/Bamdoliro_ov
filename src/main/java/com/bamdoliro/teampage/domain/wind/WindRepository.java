package com.bamdoliro.teampage.domain.wind;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WindRepository extends JpaRepository<Wind, Long> {
    @Query("SELECT w FROM Wind w")
    List<Wind> findAllDesc();
}
