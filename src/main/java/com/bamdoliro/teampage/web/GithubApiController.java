package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.GithubService;
import com.bamdoliro.teampage.web.dto.GithubListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GithubApiController {
    private final GithubService githubService;

    @GetMapping("/github")
    public List<GithubListResponseDto> membersList(@RequestParam(required = false) Integer generation, @RequestParam(required = false) String job) {
        System.out.println("요청이 들어옴");
        if (generation != null && job != null) {
            return githubService.members(generation, job);
        } else if (generation != null) {
            return githubService.generation(generation);
        } else {
            return githubService.allMembers();
        }
    }
}
