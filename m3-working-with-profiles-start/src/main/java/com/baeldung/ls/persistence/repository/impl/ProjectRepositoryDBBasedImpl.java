package com.baeldung.ls.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.baeldung.ls.persistence.model.Project;
import com.baeldung.ls.persistence.repository.IProjectRepository;

@Repository
@Profile("prod")
public class ProjectRepositoryDBBasedImpl implements IProjectRepository {

    List<Project> projects = new ArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(ProjectRepositoryDBBasedImpl.class);

    public ProjectRepositoryDBBasedImpl() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.info("Retreiving Project using ProjectRepositoryDBBasedImpl");
        return projects.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }

}
