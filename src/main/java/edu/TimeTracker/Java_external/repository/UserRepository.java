package edu.TimeTracker.Java_external.repository;

import edu.TimeTracker.Java_external.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
