package com.bamdoliro.teampage.service;

import com.bamdoliro.teampage.domain.position.Position;
import com.bamdoliro.teampage.domain.position.PositionRepository;
import com.bamdoliro.teampage.web.dto.PositionListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Transactional
    public void save(PositionListDto position) {
        positionRepository.save(position.toEntity());
    }

    @Transactional(readOnly = true)
    public List<PositionListDto> positionList() {
        return positionRepository.findAll().stream()
                .map(PositionListDto::new)
                .collect(Collectors.toList());
    }
}
