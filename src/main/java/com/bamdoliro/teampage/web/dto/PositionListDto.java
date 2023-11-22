package com.bamdoliro.teampage.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionListDto {
    private String position;
    private List<Integer> generation;

    @Builder
    public PositionListDto(String position, List<Integer> generation) {
        this.position = position;
        this.generation = generation;
    }
}
