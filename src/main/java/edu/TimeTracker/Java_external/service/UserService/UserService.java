/*
package edu.TimeTracker.Java_external.service.UserService;

import edu.TimeTracker.Java_external.domain.entity.Activity;
import edu.TimeTracker.Java_external.domain.entity.Request;
import edu.TimeTracker.Java_external.domain.entity.Track;
import edu.TimeTracker.Java_external.service.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.util.List;

import static java.util.Objects.nonNull;

public class UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static UserService INSTANCE;

    private DAOFactory factory;

    private UserService() {
        factory = new Factory();
    }
    */
/**
     * Singleton
     *
     * @return INSTANCE
     *//*

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public int getRecords(int UserId) {
        return factory.getTrackDao().getRecords(UserId);
    }

    public List<Track> getTracksWithPagination(int userID, int offset, int records) {
        return factory.getTrackDao().getAllWithPagination(userID, offset, records);
    }


    public void updateTracks(String trackId, String time, int id) {
        boolean validTime = Validation.getInstance().validTime(time);
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
    }

    public List<Activity> getActivityList() {
        return factory.getActivityDao().getAllWithPagination(0,1000);
    }

    public void addRequest(String activityId, int id) {
        Request request = new Request();
        request.setType(Request.Type.ADD);
        request.setActivity(factory.getActivityDao().getById(Integer.parseInt(activityId)));
        request.setUser(factory.getUserDao().getById(id));
        factory.getRequestDao().create(request);
    }

    public void deleteRequest(String trackId) {
        factory.getRequestDao().delete(Integer.parseInt(trackId));
    }
}
*/
