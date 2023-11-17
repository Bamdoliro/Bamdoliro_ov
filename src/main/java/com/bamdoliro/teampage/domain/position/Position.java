package com.bamdoliro.teampage.domain.position;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Position {
    @Id
    String position;

    public Position(String position) {
        this.position = position;
    }
}
