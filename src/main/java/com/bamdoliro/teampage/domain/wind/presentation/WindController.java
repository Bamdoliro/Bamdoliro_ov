package com.bamdoliro.teampage.domain.wind.presentation;

import com.bamdoliro.teampage.domain.wind.service.WindService;
import com.bamdoliro.teampage.domain.wind.presentation.dto.response.WindRandomListResponseDto;
import com.bamdoliro.teampage.domain.wind.presentation.dto.request.WindSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class WindController {
    private final WindService windService;

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> save(@RequestBody WindSaveRequestDto requestDto) {
        Map<String, String> response = new HashMap<>();
        String message = "server error";

        if (requestDto.getWind().isBlank()) {
            message = "공백을 입력할 수 없습니다.";
            response.put("message", message);
            return ResponseEntity.badRequest().body(response);
        }
        if (requestDto.getWind().length() > 35) {
            message = "35글자수 제한을 넘었습니다.";
            response.put("message", message);
            return ResponseEntity.badRequest().body(response);
        }
        if (requestDto.getWind().length() <= 35) {
            windService.save(requestDto);
            message = "\"" + requestDto.getWind() + "\"" + "이 등록되었습니다.";
            response.put("message", message);
            return ResponseEntity.ok().body(response);
        }

        response.put("message", message);
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/randomList")
    public List<WindRandomListResponseDto> randomList() {
        return windService.randomList();
    }
}
