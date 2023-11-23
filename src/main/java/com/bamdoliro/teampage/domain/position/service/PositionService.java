package com.bamdoliro.teampage.domain.position.service;

import com.bamdoliro.teampage.domain.position.domain.repository.PositionRepository;
import com.bamdoliro.teampage.domain.position.presentation.dto.request.PositionsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Transactional
    public void save(PositionsSaveRequestDto position) {
        positionRepository.save(position.toEntity());
    }

    @Transactional(readOnly = true)
    public List<PositionsSaveRequestDto> positionList() {
        return positionRepository.findAll().stream()
                .map(PositionsSaveRequestDto::new)
                .collect(Collectors.toList());
    }
}
