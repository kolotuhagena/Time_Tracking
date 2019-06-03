package edu.timeTracker.java_external.repository;

import edu.timeTracker.java_external.domain.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request, Integer> {

    void deleteById(long parseLong);
}
