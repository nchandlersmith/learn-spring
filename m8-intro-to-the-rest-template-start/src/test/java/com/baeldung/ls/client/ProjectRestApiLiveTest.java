package com.baeldung.ls.client;

import static org.junit.Assert.assertThat;

import javax.annotation.PostConstruct;

import com.baeldung.ls.web.dto.ProjectDto;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjectRestApiLiveTest {

    @LocalServerPort
    private int port;
    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void setupPort() {
        baseUrl = "http://localhost:" + port + "/projects/";
    }

    @Test
    public void givenProjectExists_whenGet_thenSuccess() {
        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(baseUrl + "1", ProjectDto.class);
        assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
    }

}