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
    public void membersList() {
        githubService.batchSave();
    }
}
