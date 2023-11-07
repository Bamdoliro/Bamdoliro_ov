package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.GithubService;
import com.bamdoliro.teampage.service.WindService;
import com.bamdoliro.teampage.web.dto.GithubListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final WindService windService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
