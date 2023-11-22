package com.bamdoliro.teampage.service;

import com.bamdoliro.teampage.domain.member.MemberRepository;
import com.bamdoliro.teampage.web.dto.PositionListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public List<PositionListDto> getPositionGeneration() {
        List<Object[]> results = memberRepository.getPositionGenerations();
        List<PositionListDto> positionList = new ArrayList<>();

        for (Object[] result : results) {
            String position = (String) result[0];
            String generationsString = (String) result[1];
            List<Integer> generations = Arrays.stream(generationsString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            PositionListDto dto = PositionListDto.builder()
                    .position(position)
                    .generation(generations)
                    .build();
            positionList.add(dto);
        }
        return positionList;
    }
}
