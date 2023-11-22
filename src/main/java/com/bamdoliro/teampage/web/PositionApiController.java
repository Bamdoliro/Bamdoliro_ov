package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.PositionService;
import com.bamdoliro.teampage.web.dto.PositionSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PositionApiController {
    private final PositionService positionService;

    @PostMapping("/position")
    public ResponseEntity<String> save(@RequestBody PositionSaveDto positionSaveDto) {
        if (positionSaveDto != null) {
            positionService.save(positionSaveDto);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("position 값을 보내주세요!");
        }
    }
}
