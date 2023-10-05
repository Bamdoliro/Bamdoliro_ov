package com.bamdoliro.teampage.service;

import com.bamdoliro.teampage.domain.wind.WindRepository;
import com.bamdoliro.teampage.web.dto.WindSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WindService {
    private final WindRepository windRepository;

    @Transactional
    public Long save(WindSaveRequestDto windSaveRequestDto) {
        return windRepository.save(windSaveRequestDto.toEntity()).getId();
    }
}
