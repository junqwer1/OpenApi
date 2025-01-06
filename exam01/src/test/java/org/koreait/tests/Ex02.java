package org.koreait.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@SpringBootTest
public class Ex02 {

    private RestTemplate restTemplate;

    @BeforeEach
    void init() {
        restTemplate = new RestTemplate();
    }

    @Test
    void test1() {
//        요청 헤더 S
        HttpHeaders headers = new HttpHeaders();
//        Content-Type: application/x-www-form-urlencoded
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        요청 헤더 E

//        요청 바디 S
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email", "user01@test.org");
        params.add("password", "1234");
        params.add("confirmPassword", "1234");
        params.add("name", "사용자01");
//        요청 바디 E

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String url = "https://localhost:3000/member/join";
        ResponseEntity<Void> response = restTemplate.postForEntity(URI.create(url), request, Void.class);
        System.out.println(response);
    }

}