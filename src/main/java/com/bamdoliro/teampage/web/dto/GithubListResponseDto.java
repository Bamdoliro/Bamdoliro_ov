package com.bamdoliro.teampage.web.dto;

import com.bamdoliro.teampage.domain.member.Member;
import com.bamdoliro.teampage.domain.position.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GithubListResponseDto {
    private String githubId;
    private String name;
    private String profile_url;
    private Long generation;
    private String position;

    public GithubListResponseDto(Member member) {
        this.githubId = member.getGithubId();
        this.name = member.getName();
        this.profile_url = member.getProfile_url();
        this.generation = member.getGeneration();
        this.position = member.getPosition().getPosition();
    }
}
