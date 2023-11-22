package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.MemberService;
import com.bamdoliro.teampage.web.dto.PositionListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @GetMapping("/position")
    public List<PositionListDto> positionList() {
        return memberService.getPositionGeneration();
    }
}
