package edu.TimeTracker.Java_external.entity.DAO.Factory;

import edu.TimeTracker.Java_external.entity.DAO.ActivityDao;
import edu.TimeTracker.Java_external.entity.DAO.RequestDao;
import edu.TimeTracker.Java_external.entity.DAO.TrackDao;
import edu.TimeTracker.Java_external.entity.DAO.UserDao;
import edu.TimeTracker.Java_external.entity.Request;

import java.sql.Connection;

/**
 * Factory of objects for work with database
 */
public interface DAOFactory {

    /**
     * @return An object to control the persistent state of the user object.
     */
    UserDao getUserDao();

    /**
     * @return An object to control the persistent state of the activity object.
     */
    ActivityDao getActivityDao();

    /**
     * @return An object to control the persistent state of the track object.
     */
    TrackDao getTrackDao();

    /**
     * @return An object to control the persistent state of the request object.
     */
    RequestDao getRequestDao();

}
