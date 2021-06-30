package com.ramiaslan.security.repository;

import com.ramiaslan.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}