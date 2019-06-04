package edu.time_tracker.java_external.service.user_service;

import edu.time_tracker.java_external.domain.entity.Activity;
import edu.time_tracker.java_external.domain.entity.Request;
import edu.time_tracker.java_external.domain.entity.Track;
import edu.time_tracker.java_external.domain.entity.User;
import edu.time_tracker.java_external.repository.ActivityRepo;
import edu.time_tracker.java_external.repository.RequestRepo;
import edu.time_tracker.java_external.repository.TrackRepo;
import edu.time_tracker.java_external.repository.UserRepository;
import edu.time_tracker.java_external.service.ValidationService;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final TrackRepo trackRepo;

    private final ActivityRepo activityRepo;

    private final RequestRepo requestRepo;

    private final ValidationService validationService;

    public UserService(UserRepository userRepository, TrackRepo trackRepo, ActivityRepo activityRepo, RequestRepo requestRepo, ValidationService validationService) {
        this.userRepository = userRepository;
        this.trackRepo = trackRepo;
        this.activityRepo = activityRepo;
        this.requestRepo = requestRepo;
        this.validationService = validationService;
    }




    public long getRecords() {
        return userRepository.count();
    }

    public Optional<User> getUserFromDB(String name)  {

        return userRepository.findByUsername(name);
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public List<Track> getTracks(int userID) {
        Optional<List<Track>> byUserId = trackRepo.findByUserId(userID);
        return byUserId.orElse(null);
    }


    public void updateTracks(String trackId, String time) {
        boolean validTime = validationService.validTime(time);
        if(validTime && nonNull(trackId)){
            Track track = trackRepo.findById(Integer.valueOf(trackId)).orElse(null);
            String[] timeCropped = time.split(":");
            Time elapsedTime;
            int timeHelper=0;
            for (String s : timeCropped) {
                timeHelper = Integer.parseInt(s) + timeHelper * 60;
            }
            elapsedTime = new Time(timeHelper*1000);
            track.setElapsedTime(elapsedTime);
            track.setCompleted(true);
            track.setActive(false);
            trackRepo.save(track);
        }
    }

    public List<Activity> getActivityList() {
        Iterable<Activity> iterator = activityRepo.findAll();
        List<Activity> activities = new ArrayList<>();
        iterator.forEach(activities::add);
        return activities;
    }

    public void addRequest(String activityId, int id) {
        Request request = new Request();
        request.setType(Request.Type.ADD);
        request.setActivity(activityRepo.findById(Integer.parseInt(activityId)).orElse(null));
        request.setUser(userRepository.findById((long) id).orElse(null));
        requestRepo.save(request);
    }

    public void deleteRequest(String trackId) {
        requestRepo.deleteById(Long.parseLong(trackId));
    }

    public Optional<User> getById(Long userId) {
        return userRepository.findById(userId);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
