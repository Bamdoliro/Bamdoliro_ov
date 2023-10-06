package com.bamdoliro.teampage.web.dto;

import com.bamdoliro.teampage.domain.wind.Wind;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WindSaveRequestDto {
    private String wind;

    @Builder
    public WindSaveRequestDto(String wind) {
        this.wind = wind;
    }

    public Wind toEntity() {
        return Wind.builder()
                .wind(wind)
                .build();
    }
}
