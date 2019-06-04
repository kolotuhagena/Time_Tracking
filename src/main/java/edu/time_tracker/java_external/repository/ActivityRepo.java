package edu.time_tracker.java_external.repository;

import edu.time_tracker.java_external.domain.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity, Integer> {
}
