package com.bamdoliro.teampage.domain.position.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionsListResponseDto {
    private String position;
    private List<Integer> generation;

    @Builder
    public PositionsListResponseDto(String position, List<Integer> generation) {
        this.position = position;
        this.generation = generation;
    }
}
