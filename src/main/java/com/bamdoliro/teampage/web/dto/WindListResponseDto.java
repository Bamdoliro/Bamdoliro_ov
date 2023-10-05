package com.bamdoliro.teampage.web.dto;

import com.bamdoliro.teampage.domain.wind.Wind;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WindListResponseDto {
    private Long id;
    private String wind;

    public WindListResponseDto(Wind wind) {
        this.id = wind.getId();
        this.wind = wind.getWind();
    }
}
