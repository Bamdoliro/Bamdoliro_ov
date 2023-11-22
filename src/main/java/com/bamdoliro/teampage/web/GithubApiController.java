package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/github")
public class GithubApiController {
    private final GithubService githubService;

    @GetMapping("/update")
    public void membersList() {
        githubService.batchSave();
    }
}
