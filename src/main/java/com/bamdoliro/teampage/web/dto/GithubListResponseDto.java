package com.bamdoliro.teampage.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GithubListResponseDto {
    private String id;
    private String profile_img;
    private Integer generation;
}
