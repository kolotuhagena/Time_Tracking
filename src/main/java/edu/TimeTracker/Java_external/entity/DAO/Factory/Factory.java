package edu.TimeTracker.Java_external.entity.DAO.Factory;

import edu.TimeTracker.Java_external.entity.DAO.ActivityDao;
import edu.TimeTracker.Java_external.entity.DAO.TrackDao;
import edu.TimeTracker.Java_external.entity.DAO.UserDao;
import edu.TimeTracker.Java_external.entity.Request;

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
    public Request getRequestDao() {
        return new Request();
    }
}
