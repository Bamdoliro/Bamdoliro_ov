package com.bamdoliro.teampage.domain.member.presentation.dto.response;

import com.bamdoliro.teampage.domain.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MembersListResponseDto {
    private String githubId;
    private String name;
    private String profile_url;
    private Long generation;
    private String position;

    public MembersListResponseDto(Member member) {
        this.githubId = member.getGithubId();
        this.name = member.getName();
        this.profile_url = member.getProfile_url();
        this.generation = member.getGeneration();
        this.position = member.getPosition().getPosition();
    }
}
