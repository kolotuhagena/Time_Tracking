package edu.time_tracker.java_external.persistence.dao.Factory;

import edu.time_tracker.java_external.persistence.dao.*;

public class Factory implements DAOFactory {

    @Override
    public UserDao getUserDao() {
        return new UserDao();
    }

    @Override
    public ActivityDao getActivityDao() {
        return new ActivityDao();
    }

    @Override
    public TrackDao getTrackDao() {
        return new TrackDao();
    }

    @Override
    public RequestDao getRequestDao() {
        return new RequestDao();
    }

}
