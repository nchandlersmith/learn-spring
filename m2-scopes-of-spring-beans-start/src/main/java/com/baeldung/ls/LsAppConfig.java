package com.baeldung.ls;

import com.baeldung.ls.persistence.repository.IProjectRepository;
import com.baeldung.ls.persistence.repository.impl.ProjectRepositoryImpl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LsAppConfig {
    // @Bean
    // Specifying singleton scope is not needed; it is the default scope
    // Use one of the two annotations below
    // @Scope("singleton")
    // @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    // public IProjectRepository projectRepository() {
    // return new ProjectRepositoryImpl();
    // }

    @Bean
    // Prototype scope creates new instance whenever bean is requested
    // Use one of the two anntoations below
    // @Scope("prototype")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IProjectRepository projectRepository() {
        return new ProjectRepositoryImpl();
    }
}