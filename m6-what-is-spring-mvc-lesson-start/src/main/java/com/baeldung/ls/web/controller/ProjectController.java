package com.baeldung.ls.web.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.time.LocalDate;

import com.baeldung.ls.persistence.model.Project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @GetMapping(path = "/1")
    public Project findOne() {

        return new Project(randomAlphabetic(10), LocalDate.now());
    }

}