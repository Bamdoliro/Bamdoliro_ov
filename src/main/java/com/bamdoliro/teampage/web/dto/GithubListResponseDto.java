package com.bamdoliro.teampage.web.dto;

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
}
