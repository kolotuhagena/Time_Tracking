package edu.timeTracker.java_external.repository;

import edu.timeTracker.java_external.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String username);
}
