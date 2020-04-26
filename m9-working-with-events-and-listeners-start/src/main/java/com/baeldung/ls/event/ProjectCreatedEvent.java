package com.baeldung.ls.event;

public class ProjectCreatedEvent {

    private Long projectId;

    public ProjectCreatedEvent(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
