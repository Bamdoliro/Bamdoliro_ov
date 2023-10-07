package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.WindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final WindService windService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/descList")
    public String descList(Model model) {
        model.addAttribute("wind", windService.descList());
        return "descList";
    }

    @GetMapping("/ascList")
    public String ascList(Model model) {
        model.addAttribute("wind", windService.ascList());
        return "ascList";
    }
}
