package edu.time_tracker.java_external.repository;

import edu.time_tracker.java_external.domain.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrackRepo extends JpaRepository<Track, Integer> {
    Optional<List<Track>> findByUserId(int userID);
}
