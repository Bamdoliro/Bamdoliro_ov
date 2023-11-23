package com.bamdoliro.teampage.domain.wind.presentation.dto.response;

import com.bamdoliro.teampage.domain.wind.domain.Wind;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WindRandomListResponseDto {
    private Long id;
    private String wind;

    public WindRandomListResponseDto(Wind wind) {
        this.id = wind.getId();
        this.wind = wind.getWind();
    }
}

