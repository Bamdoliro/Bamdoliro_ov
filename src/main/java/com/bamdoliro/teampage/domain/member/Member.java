package com.bamdoliro.teampage.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    @Column
    private String position;

    @Builder
    public Member(String githubId, String name, String profile_url, Long generation, String position) {
        this.githubId = githubId;
        this.name = name;
        this.profile_url = profile_url;
        this.generation = generation;
        this.position = position;
    }
}
