package com.bamdoliro.teampage.domain.member;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Member {
    @Id
    @Column
    String githubId;

    @Column
    Integer generation;

    @Column
    String position;
}
