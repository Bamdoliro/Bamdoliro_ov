package com.bamdoliro.teampage.domain.position;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Position {
    @Id
    private String position;

    @Builder
    public Position(String position) {
        this.position = position;
    }
}
