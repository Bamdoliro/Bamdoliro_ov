package com.bamdoliro.teampage.domain.wind.presentation.dto.response;

import com.bamdoliro.teampage.domain.wind.domain.Wind;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WindListResponseDto {
    private Long id;
    private String wind;
    private LocalDateTime createDate;

    public WindListResponseDto(Wind wind) {
        this.id = wind.getId();
        this.wind = wind.getWind();
        this.createDate = wind.getCreateDate();
    }
}
