package com.baeldung.ls;

import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl2;
import com.baeldung.ls.service.IProjectService;
import com.baeldung.ls.service.impl.ProjectServiceImplFieldInjection;
import com.baeldung.ls.service.impl.ProjectServiceImplSetterInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LsAppConfig {

    @Bean
    public IProjectService projectServiceImplSetterInjection() {
        return new ProjectServiceImplSetterInjection();
    }

    @Bean
    public IProjectService projectServiceImplFieldInjection() {
        return new ProjectServiceImplFieldInjection();
    }

    @Bean
    public IProjectRepository projectRepositoryImpl2() {
        return new ProjectRepositoryImpl2();
    }
}
