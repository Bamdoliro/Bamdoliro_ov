package com.bamdoliro.teampage.domain.position.presentation;

import com.bamdoliro.teampage.domain.member.presentation.dto.response.MembersListResponseDto;
import com.bamdoliro.teampage.domain.member.service.MemberService;
import com.bamdoliro.teampage.domain.position.presentation.dto.response.PositionsListResponseDto;
import com.bamdoliro.teampage.domain.position.service.PositionService;
import com.bamdoliro.teampage.domain.position.presentation.dto.request.PositionsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/position")
@RestController
public class PositionController {
    private final PositionService positionService;
    private final MemberService memberService;

    @GetMapping("/info")
    public List<PositionsListResponseDto> positionList() {
        return memberService.getPositionGeneration();
    }

    @GetMapping("/list")
    public List<MembersListResponseDto> memberList() {
        return memberService.getMemberList();
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody PositionsSaveRequestDto positionSaveDto) {
        if (positionSaveDto != null) {
            positionService.save(positionSaveDto);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("position 값을 보내주세요!");
        }
    }
}
