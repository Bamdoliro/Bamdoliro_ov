package com.bamdoliro.teampage.web.dto;

import com.bamdoliro.teampage.domain.position.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PositionSaveDto {
    String position;

    public PositionSaveDto(Position position) {
        this.position = position.getPosition();
    }

    public Position toEntity() {
        return Position.builder()
                .position(position)
                .build();
    }
}
