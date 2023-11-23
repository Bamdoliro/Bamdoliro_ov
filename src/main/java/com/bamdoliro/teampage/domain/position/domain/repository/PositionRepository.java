package com.bamdoliro.teampage.domain.position.domain.repository;

import com.bamdoliro.teampage.domain.position.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
