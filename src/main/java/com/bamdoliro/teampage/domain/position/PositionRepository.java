package com.bamdoliro.teampage.domain.position;

import com.bamdoliro.teampage.domain.wind.Wind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {
    @Query("SELECT p FROM Position p ORDER BY p.id DESC")
    List<Position> findAllDesc();
}
