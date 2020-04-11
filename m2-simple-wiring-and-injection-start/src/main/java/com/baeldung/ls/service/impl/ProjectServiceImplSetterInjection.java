package com.baeldung.ls.service.impl;

import java.util.Optional;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.service.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProjectServiceImplSetterInjection implements IProjectService {

    IProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(@Qualifier("projectRepositoryImpl2") IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(final Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(final Project project) {
        return projectRepository.save(project);
    }

}