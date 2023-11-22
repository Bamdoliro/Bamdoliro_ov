package com.bamdoliro.teampage.web.dto;

import com.bamdoliro.teampage.domain.position.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PositionListDto {
    String position;

    public PositionListDto(Position position) {
        this.position = position.getPosition();
    }

    public Position toEntity() {
        return Position.builder()
                .position(position)
                .build();
    }
}
