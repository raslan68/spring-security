package com.ramiaslan.security.repository;

import com.ramiaslan.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ramazan Aslan
 * @since 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
