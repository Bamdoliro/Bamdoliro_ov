package com.bamdoliro.teampage.domain.position.presentation;

import com.bamdoliro.teampage.domain.position.service.PositionService;
import com.bamdoliro.teampage.domain.position.presentation.dto.request.PositionsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PositionController {
    private final PositionService positionService;

    @PostMapping("/position")
    public ResponseEntity<String> save(@RequestBody PositionsSaveRequestDto positionSaveDto) {
        if (positionSaveDto != null) {
            positionService.save(positionSaveDto);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("position 값을 보내주세요!");
        }
    }
}
