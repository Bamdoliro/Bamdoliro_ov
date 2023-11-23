package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GithubController {
    private final GithubService githubService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void membersList() {
        githubService.batchSave();
    }
}
