package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PositionApiController {
    private final PositionService positionService;

    @GetMapping("/position/{position}")
    public ResponseEntity<String> save(@PathVariable String position) {
        if (position != null) {
            positionService.save(position);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("position 값을 보내주세요!");
        }
    }
}
