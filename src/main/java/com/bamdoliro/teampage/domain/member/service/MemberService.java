package com.bamdoliro.teampage.domain.member.service;

import com.bamdoliro.teampage.domain.member.domain.repository.MemberRepository;
import com.bamdoliro.teampage.domain.member.presentation.dto.response.MembersListResponseDto;
import com.bamdoliro.teampage.domain.position.presentation.dto.response.PositionsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public List<PositionsListResponseDto> getPositionGeneration() {
        List<Object[]> results = memberRepository.getPositionGenerations();
        List<PositionsListResponseDto> positionList = new ArrayList<>();

        for (Object[] result : results) {
            String position = (String) result[0];
            String generationsString = (String) result[1];
            List<Integer> generations = Arrays.stream(generationsString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            PositionsListResponseDto dto = PositionsListResponseDto.builder()
                    .position(position)
                    .generation(generations)
                    .build();
            positionList.add(dto);
        }
        return positionList;
    }

    @Transactional(readOnly = true)
    public List<MembersListResponseDto> getMemberList() {
        return memberRepository.findAllAsc().stream()
                .map(MembersListResponseDto::new)
                .collect(Collectors.toList());
    }
}
