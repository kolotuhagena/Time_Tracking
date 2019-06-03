package edu.timeTracker.java_external.repository;

import edu.timeTracker.java_external.domain.entity.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TrackRepo extends CrudRepository<Track, Integer> {
    Optional<List<Track>> findByUserId(int userID);
}
