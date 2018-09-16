package com.jvdkolk.wickettest.config;

import com.jvdkolk.entities.AbstractPersistable;
import com.jvdkolk.repositories.QueryDslRepository;
import com.jvdkolk.services.SimpleUserService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Since we are using a multi module project
 * we have to entityscan and repository scan because these
 * things are in a diffrent module
 */
@Configuration
@EntityScan(basePackageClasses = AbstractPersistable.class)
@ComponentScan(basePackageClasses = SimpleUserService.class)
@EnableJpaRepositories(basePackageClasses = QueryDslRepository.class)
public class BeanConfig {
}
