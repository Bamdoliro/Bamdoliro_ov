package com.bamdoliro.teampage.domain.wind.domain.repository;

import com.bamdoliro.teampage.domain.wind.domain.Wind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WindRepository extends JpaRepository<Wind, Long> {
    @Query("SELECT w FROM Wind w ORDER BY w.id DESC")
    List<Wind> findAllDesc();

    @Query("SELECt w FROM Wind w ORDER BY w.id ASC")
    List<Wind> findAllAsc();
}
