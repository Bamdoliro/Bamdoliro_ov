package com.bamdoliro.teampage.service;

import com.bamdoliro.teampage.web.dto.GithubListResponseDto;
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

    public List<GithubListResponseDto> membersList(Integer generation, String job) {
        String responseBody = getMembers( job + "-" + generation);
        JSONArray jsonArray = new JSONArray(responseBody);

        List<GithubListResponseDto> githubList = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            String id = (String) jsonObject.get("login");
            String profile_img = (String) jsonObject.get("avatar_url");

            GithubListResponseDto dto = new GithubListResponseDto();
            dto.setId(id);
            dto.setProfile_img(profile_img);
            dto.setGeneration(generation);

            githubList.add(dto);
        }
        return githubList;
    }

    public String getMembers(String team) {
        String apiUrl = String.format("https://api.github.com/orgs/Bamdoliro/teams/%s/members", team);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/vnd.github+json");
        headers.add("Authorization", "Bearer " + token);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

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
