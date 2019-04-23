package edu.TimeTracker.Java_external.repository;

import edu.TimeTracker.Java_external.domain.entity.Track;
import edu.TimeTracker.Java_external.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TrackRepo extends CrudRepository<Track, Integer> {
    Optional<List<Track>> findByUserId(int userID);
}
