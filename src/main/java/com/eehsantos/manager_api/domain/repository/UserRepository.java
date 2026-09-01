package com.eehsantos.manager_api.domain.repository;

import com.eehsantos.manager_api.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    void deleteById(Long id);
}
