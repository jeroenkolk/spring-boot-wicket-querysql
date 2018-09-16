package com.jvdkolk.repositories;

import com.jvdkolk.entities.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Simple querydsl enabled repository
 * @param <E> the entity
 */
@NoRepositoryBean
public interface QueryDslRepository<E extends AbstractPersistable>
        extends JpaRepository<E, Long>, QuerydslPredicateExecutor<E> {
}
