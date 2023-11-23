package com.bamdoliro.teampage.domain.wind.domain;

import com.bamdoliro.teampage.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Wind extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String wind;

    @Builder
    public Wind(String wind) {
        this.wind = wind;
    }
}
