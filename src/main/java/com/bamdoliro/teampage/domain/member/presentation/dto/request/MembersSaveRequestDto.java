package com.bamdoliro.teampage.domain.member.presentation.dto.request;

import com.bamdoliro.teampage.domain.member.domain.Member;
import com.bamdoliro.teampage.domain.position.domain.Position;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class MembersSaveRequestDto {
    private String login;
    private String name;
    private String avatar_url;
    private Long generation;
    private Position position;

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
