package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.WindService;
import com.bamdoliro.teampage.web.dto.WindSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WindApiController {
    private final WindService windService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody WindSaveRequestDto requestDto) {
        if (requestDto.getWind().length() <= 35) {
            windService.save(requestDto);
            return ResponseEntity.ok("바람이 등록되었습니다.");
        }
        else
            return ResponseEntity.badRequest().body("35글자수 제한을 넘었습니다.");
    }
}
