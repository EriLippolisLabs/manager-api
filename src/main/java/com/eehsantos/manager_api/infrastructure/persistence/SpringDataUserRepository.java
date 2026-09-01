package com.eehsantos.manager_api.infrastructure.persistence;

import com.eehsantos.manager_api.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
}
