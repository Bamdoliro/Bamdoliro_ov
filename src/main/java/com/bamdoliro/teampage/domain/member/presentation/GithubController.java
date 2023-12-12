package com.bamdoliro.teampage.domain.member.presentation;

import com.bamdoliro.teampage.domain.member.service.MemberSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/github")
@RestController
public class GithubController {
    private final MemberSaveService githubService;

    @GetMapping("/update")
    @Scheduled(cron = "0 0 12 * * ?")
    public String membersList() {
        githubService.batchSave();
        return "success";
    }
}
