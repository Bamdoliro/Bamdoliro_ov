package com.bamdoliro.teampage.web;

import com.bamdoliro.teampage.domain.position.Position;
import com.bamdoliro.teampage.service.PositionService;
import com.bamdoliro.teampage.web.dto.PositionListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PositionApiController {
    private final PositionService positionService;

    @PostMapping("/position")
    public ResponseEntity<String> save(@RequestBody PositionListDto positionListDto) {
        if (positionListDto != null) {
            positionService.save(positionListDto);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("position 값을 보내주세요!");
        }
    }

    @GetMapping("/position")
    public List<PositionListDto> positionList() {
        List<PositionListDto> sdfsd = positionService.positionList();
        System.out.println(sdfsd);
        return sdfsd;
    }
}
