package edu.timeTracker.java_external.repository;

        import edu.timeTracker.java_external.domain.entity.Activity;
        import org.springframework.data.repository.CrudRepository;

public interface ActivityRepo extends CrudRepository<Activity, Integer> {
}
