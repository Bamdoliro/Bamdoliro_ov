package com.bamdoliro.teampage.domain.member.service;

import com.bamdoliro.teampage.domain.member.domain.repository.MemberRepository;
import com.bamdoliro.teampage.domain.position.domain.Position;
import com.bamdoliro.teampage.domain.position.domain.repository.PositionRepository;
import com.bamdoliro.teampage.domain.member.presentation.dto.request.MembersSaveRequestDto;
import com.bamdoliro.teampage.domain.position.presentation.dto.request.PositionsSaveRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberSaveService {
    private final PositionRepository positionRepository;
    private final MemberRepository memberRepository;

    @Value("${spring.github.token}")
    private String token;

    @Transactional
    public void batchSave() {
        memberRepository.cleanTable();
        for(int i = 1; i < getGeneration() + 1; i++) {
            List<PositionsSaveRequestDto> positions = positionRepository.findAll().stream()
                    .map(PositionsSaveRequestDto::new)
                    .collect(Collectors.toList());
            for(PositionsSaveRequestDto position : positions) {
                position.setPosition(position.getPosition().replaceAll("\\s", "-"));
                List<MembersSaveRequestDto> members = membersList(i, position.getPosition());
                if (members != null) {
                    for(MembersSaveRequestDto member : members) {
                        memberRepository.save(member.toEntity());
                        System.out.println(i + "기수 " + position.getPosition() + " " + member.getLogin() + "저장 완료");
                    }
                }
            }
        }
    }

    private List<MembersSaveRequestDto> membersList(int generation, String position) {
        String responseBody = getMembers(position + "-" + generation);
        if (responseBody == null) {
            return null;
        }
        JSONArray jsonArray = new JSONArray(responseBody);

        List<MembersSaveRequestDto> githubList = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            String id = (String) jsonObject.get("login");

            MembersSaveRequestDto member = getUser(id);
            member.setGeneration(new Long(generation));
            member.setPosition(new Position().builder()
                    .position(position.replaceAll("-", " "))
                    .build());

            githubList.add(member);
        }
        return githubList;
    }

    private MembersSaveRequestDto getUser(String id)  {
        String apiUrl = "https://api.github.com/users/" + id;
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + token);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MembersSaveRequestDto githubUser = objectMapper.readValue(response.getBody(), MembersSaveRequestDto.class);
            return githubUser;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }

    private String getMembers(String team) {
        String apiUrl = String.format("https://api.github.com/orgs/Bamdoliro/teams/%s/members", team);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github+json");
        headers.set("Authorization", "Bearer " + token);
        headers.set("User-Agent", "BamdoliroTeamPage/1.0");
        headers.set("X-GitHub-Api-Version", "2022-11-28");

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                String responseBody = response.getBody();
                return responseBody;
            } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("Member를 찾을 수 없음");
            } else {
                throw new RuntimeException("알 수 없는 에러 발생");
            }
        } catch (Exception e) {
            return null;
        }
    }

    private int getGeneration() {
        int thisYear = LocalDate.now().getYear();
        int startYear = 2021;
        return thisYear - startYear + 1;
    }
}
