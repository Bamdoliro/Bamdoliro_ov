package com.bamdoliro.teampage.service;

import com.bamdoliro.teampage.domain.wind.WindRepository;
import com.bamdoliro.teampage.web.dto.WindListResponseDto;
import com.bamdoliro.teampage.web.dto.WindSaveRequestDto;
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
    public List<WindListResponseDto> list() {
        return windRepository.findAllDesc().stream()
                .map(WindListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WindListResponseDto> randomList() {
        List<WindListResponseDto> list = windRepository.findAllDesc().stream()
                .map(WindListResponseDto::new)
                .collect(Collectors.toList());

        Collections.shuffle(list, new Random());
        return list;
    }
}
