package edu.TimeTracker.Java_external.persistence.DAO.Factory;

import edu.TimeTracker.Java_external.persistence.DAO.ActivityDao;
import edu.TimeTracker.Java_external.persistence.DAO.RequestDao;
import edu.TimeTracker.Java_external.persistence.DAO.TrackDao;
import edu.TimeTracker.Java_external.persistence.DAO.UserDao;

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
