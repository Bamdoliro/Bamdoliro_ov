package com.bamdoliro.teampage.web.dto;

import com.bamdoliro.teampage.domain.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String login;
    private String name;
    private String avatar_url;
    private Long generation;
    private String position;

    public Member toEntity() {
        return Member.builder()
                .githubId(login)
                .name(name)
                .profile_url(avatar_url)
                .generation(generation)
                .position(position)
                .build();
    }
}
