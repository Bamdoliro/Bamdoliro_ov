package com.bamdoliro.teampage.domain.member.domain;

import com.bamdoliro.teampage.domain.position.domain.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @Column
    private String githubId;

    @Column
    private String name;

    @Column
    private String profile_url;

    @Column
    private Long generation;

    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;

    @Builder
    public Member(String githubId, String name, String profile_url, Long generation, Position position) {
        this.githubId = githubId;
        this.name = name;
        this.profile_url = profile_url;
        this.generation = generation;
        this.position = position;
    }
}
