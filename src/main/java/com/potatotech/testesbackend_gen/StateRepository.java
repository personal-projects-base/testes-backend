package com.potatotech.testesbackend_gen;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, UUID> {
    Page<StateEntity> findAll(Specification<StateEntity> spec, Pageable pageable);
}
