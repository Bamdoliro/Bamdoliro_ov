package com.bamdoliro.teampage.domain.wind.service;

import com.bamdoliro.teampage.domain.wind.domain.repository.WindRepository;
import com.bamdoliro.teampage.domain.wind.presentation.dto.response.WindListResponseDto;
import com.bamdoliro.teampage.domain.wind.presentation.dto.response.WindRandomListResponseDto;
import com.bamdoliro.teampage.domain.wind.presentation.dto.request.WindSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WindService {
    private final WindRepository windRepository;

    @Transactional
    public Long save(WindSaveRequestDto windSaveRequestDto) {
        return windRepository.save(windSaveRequestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<WindListResponseDto> descList() {
        return windRepository.findAllDesc().stream()
                .map(WindListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WindListResponseDto> ascList() {
        return windRepository.findAllAsc().stream()
                .map(WindListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WindRandomListResponseDto> randomList() {
        List<WindRandomListResponseDto> list = windRepository.findAllDesc().stream()
                .map(WindRandomListResponseDto::new)
                .collect(Collectors.toList());

        Collections.shuffle(list, new Random());
        return list;
    }
}
