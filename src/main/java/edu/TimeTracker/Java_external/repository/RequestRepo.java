package edu.TimeTracker.Java_external.repository;

import edu.TimeTracker.Java_external.domain.entity.Request;
import edu.TimeTracker.Java_external.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Integer> {

    void deleteById(long parseLong);
}
