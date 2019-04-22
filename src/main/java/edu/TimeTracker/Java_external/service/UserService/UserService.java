package edu.TimeTracker.Java_external.service.UserService;

import edu.TimeTracker.Java_external.domain.entity.Activity;
import edu.TimeTracker.Java_external.domain.entity.Request;
import edu.TimeTracker.Java_external.domain.entity.Track;
import edu.TimeTracker.Java_external.domain.entity.User;
import edu.TimeTracker.Java_external.repository.UserRepository;
import edu.TimeTracker.Java_external.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    private ValidationService validationService;*/

    public long getRecords(int UserId) {
        return userRepository.count();
    }

    public User getUserFromDB(String name) throws NullPointerException {
        User byLogin = userRepository.findByLogin(name);
        if(isNull(byLogin))
            throw new NullPointerException();
        return byLogin;
    }

    public void add(User user) {
        userRepository.save(user);
    }

    /*public List<Track> getTracksWithPagination(int userID, int offset, int records) {
        return factory.getTrackDao().getAllWithPagination(userID, offset, records);
    }*/


  /*  public void updateTracks(String trackId, String time, int id) {
        boolean validTime = validationService.validTime(time);
        if(validTime&&nonNull(trackId)&&nonNull(time)){
            Track track = factory.getTrackDao().getById(Integer.valueOf(trackId));
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
            factory.getTrackDao().update(track,track.getId());
        }
    }*/

    /*public List<Activity> getActivityList() {
        return factory.getActivityDao().getAllWithPagination(0,1000);
    }*/

    /*public void addRequest(String activityId, int id) {
        Request request = new Request();
        request.setType(Request.Type.ADD);
        request.setActivity(factory.getActivityDao().getById(Integer.parseInt(activityId)));
        request.setUser(factory.getUserDao().getById(id));
        factory.getRequestDao().create(request);
    }*/

    /*public void deleteRequest(String trackId) {
        factory.getRequestDao().delete(Integer.parseInt(trackId));
    }*/
}
