package edu.TimeTracker.Java_external.service.UserService;

import edu.TimeTracker.Java_external.domain.entity.Activity;
import edu.TimeTracker.Java_external.domain.entity.Request;
import edu.TimeTracker.Java_external.domain.entity.Track;
import edu.TimeTracker.Java_external.domain.entity.User;
import edu.TimeTracker.Java_external.repository.ActivityRepo;
import edu.TimeTracker.Java_external.repository.RequestRepo;
import edu.TimeTracker.Java_external.repository.TrackRepo;
import edu.TimeTracker.Java_external.repository.UserRepository;
import edu.TimeTracker.Java_external.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrackRepo trackRepo;

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private ValidationService validationService;


    public long getRecords(int UserId) {
        return userRepository.count();
    }

    public Optional<User> getUserFromDB(String name) throws NullPointerException {
        Optional<User> byLogin = userRepository.findByLogin(name);
        return byLogin;
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public List<Track> getTracks(int userID) {
        Optional<List<Track>> byUserId = trackRepo.findByUserId(userID);
        return byUserId.orElse(null);
    }


    public void updateTracks(String trackId, String time, int id) {
        boolean validTime = validationService.validTime(time);
        if(validTime&&nonNull(trackId)&&nonNull(time)){
            Track track = trackRepo.findById(Integer.valueOf(trackId)).orElse(null);
            String[] timeCropped = time.split(":");
            Time elapsedTime;
            int timeHelper=0;
            for (int i = 0; i < timeCropped.length; i++) {
                timeHelper = Integer.parseInt(timeCropped[i])+timeHelper*60;
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
}
