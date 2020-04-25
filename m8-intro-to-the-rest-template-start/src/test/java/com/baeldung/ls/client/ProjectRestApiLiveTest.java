package com.baeldung.ls.client;

import static org.junit.Assert.assertThat;

import com.baeldung.ls.web.dto.ProjectDto;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ProjectRestApiLiveTest {

    private static final String BASE_URL = "http://localhost:8080/projects/";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void givenProjectExists_whenGet_thenSuccess() {
        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(BASE_URL + "1", ProjectDto.class);
        assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
    }

}