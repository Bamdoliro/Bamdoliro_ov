package com.bamdoliro.teampage.domain.position.presentation.dto.request;

import com.bamdoliro.teampage.domain.position.domain.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PositionsSaveRequestDto {
    String position;

    public PositionsSaveRequestDto(Position position) {
        this.position = position.getPosition();
    }

    public Position toEntity() {
        return Position.builder()
                .position(position)
                .build();
    }
}
