package com.bamdoliro.teampage.service;

import com.bamdoliro.teampage.web.dto.GithubListResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GithubService {
    @Value("${spring.github.token}")
    private String token;

    public List<GithubListResponseDto> members(Integer generation, String job) {
        String team = job + "-" + generation;
        return membersList(team);
    }

    public List<GithubListResponseDto> generation(Integer generation) {
        String team = generation.toString();
        return membersList(team);
    }

    public List<GithubListResponseDto> allMembers() {
        return membersList("Bamdoliro");
    }

    public List<GithubListResponseDto> membersList(String team) {
        String responseBody = getMembers(team);
        JSONArray jsonArray = new JSONArray(responseBody);

        List<GithubListResponseDto> githubList = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            String id = (String) jsonObject.get("login");

            githubList.add(getUser(id));
        }
        return githubList;
    }

    public GithubListResponseDto getUser(String id)  {
        String apiUrl = "https://api.github.com/users/" + id;
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + token);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GithubListResponseDto gitHubUser = objectMapper.readValue(response.getBody(), GithubListResponseDto.class);
            return gitHubUser;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }

    public String getMembers(String team) {
        String apiUrl = String.format("https://api.github.com/orgs/Bamdoliro/teams/%s/members", team);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github+json");
        headers.set("Authorization", "Bearer " + token);
        headers.set("User-Agent", "BamdoliroTeamPage/1.0");
        headers.set("X-GitHub-Api-Version", "2022-11-28");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        List<String> rateLimitRemaining = response.getHeaders().get("X-RateLimit-Remaining");
        if (rateLimitRemaining != null && !rateLimitRemaining.isEmpty()) {
            String remainingRequests = rateLimitRemaining.get(0);
            System.out.println("남은 요청 가능 횟수: " + remainingRequests);
        } else {
            System.out.println("X-RateLimit-Remaining 헤더가 존재하지 않습니다.");
        }

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            return responseBody;
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new RuntimeException("Member를 찾을 수 없음");
        } else {
            throw new RuntimeException("알 수 없는 에러 발생");
        }
    }
}
