package com.baeldung.ls;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LsApp {

    @Autowired
    private IProjectService projectService;

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        Project project = new Project("My First Project", LocalDate.now());
        projectService.save(project);
    }
}
