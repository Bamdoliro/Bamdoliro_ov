package com.bamdoliro.teampage.domain.member.presentation;

import com.bamdoliro.teampage.domain.member.service.MemberService;
import com.bamdoliro.teampage.domain.member.presentation.dto.response.MembersListResponseDto;
import com.bamdoliro.teampage.domain.position.presentation.dto.response.PositionsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/position")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/info")
    public List<PositionsListResponseDto> positionList() {
        return memberService.getPositionGeneration();
    }

    @GetMapping("/list")
    public List<MembersListResponseDto> memberList() {
        return memberService.getMemberList();
    }
}
