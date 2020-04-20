package com.baeldung.ls.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.service.IProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/{id}")
    public Project findOne(@PathVariable Long id) {
        return this.projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/create")
    public void create(@RequestBody Project newProject) {
        this.projectService.save(newProject);
    }
}
