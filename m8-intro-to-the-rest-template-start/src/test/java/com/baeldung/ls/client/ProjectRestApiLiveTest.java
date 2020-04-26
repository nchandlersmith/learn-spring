package com.baeldung.ls.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import com.baeldung.ls.web.dto.ProjectDto;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
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
        assertNotNull(response.getBody());
    }

    @Test()
    public void givenProjentNotExists_whenGet_thenNotFoundStatus() {
        try {
            restTemplate.getForEntity(baseUrl + "10", ProjectDto.class);
        } catch (Exception e) {
            assertEquals(HttpClientErrorException.NotFound.class, e.getClass());
        }
    }

    @Test
    public void givenNewProject_whenCreated_thenSuccess() {
        ProjectDto newProject = new ProjectDto(4L, "Client Project", LocalDate.now());
        ResponseEntity<Void> response = restTemplate.postForEntity(baseUrl, newProject, void.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}