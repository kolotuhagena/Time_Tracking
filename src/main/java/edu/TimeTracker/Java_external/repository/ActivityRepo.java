package edu.TimeTracker.Java_external.repository;

        import edu.TimeTracker.Java_external.domain.entity.Activity;
        import edu.TimeTracker.Java_external.domain.entity.Track;
        import edu.TimeTracker.Java_external.domain.entity.User;
        import org.springframework.data.repository.CrudRepository;

interface ActivityRepo extends CrudRepository<Activity, Integer> {
}
