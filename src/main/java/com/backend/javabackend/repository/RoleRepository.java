package com.backend.javabackend.repository;

import com.backend.javabackend.entity.ERole;
import com.backend.javabackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}