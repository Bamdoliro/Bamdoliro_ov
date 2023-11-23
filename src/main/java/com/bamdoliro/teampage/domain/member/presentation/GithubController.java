package com.bamdoliro.teampage.domain.member.presentation;

import com.bamdoliro.teampage.domain.member.service.MemberSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GithubController {
    private final MemberSaveService githubService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void membersList() {
        githubService.batchSave();
    }
}
