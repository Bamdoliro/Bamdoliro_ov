package com.bamdoliro.teampage.service;

import com.bamdoliro.teampage.domain.position.Position;
import com.bamdoliro.teampage.domain.position.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PositionService {
    private final PositionRepository positionRepository;

    public void save(String position) {
        positionRepository.save(new Position(position));
    }
}
