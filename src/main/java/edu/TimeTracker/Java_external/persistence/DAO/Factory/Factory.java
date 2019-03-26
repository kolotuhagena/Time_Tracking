package edu.TimeTracker.Java_external.persistence.DAO.Factory;

import edu.TimeTracker.Java_external.persistence.DAO.*;

import java.util.List;

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
