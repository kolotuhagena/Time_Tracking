package edu.time_tracker.java_external.persistence.dao.Factory;

import edu.time_tracker.java_external.persistence.dao.ActivityDao;
import edu.time_tracker.java_external.persistence.dao.RequestDao;
import edu.time_tracker.java_external.persistence.dao.TrackDao;
import edu.time_tracker.java_external.persistence.dao.UserDao;

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
