package com.bamdoliro.teampage.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class GithubListResponseDto {
    private String githubId;
    private String name;
    private Long generation;
    private String position;
}
