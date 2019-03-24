package edu.TimeTracker.Java_external.service;

import edu.TimeTracker.Java_external.persistence.DAO.Factory.DAOFactory;
import edu.TimeTracker.Java_external.persistence.DAO.Factory.Factory;
import edu.TimeTracker.Java_external.persistence.entity.Activity;
import edu.TimeTracker.Java_external.persistence.entity.Request;
import edu.TimeTracker.Java_external.persistence.entity.Track;
import edu.TimeTracker.Java_external.persistence.entity.User;
import org.apache.log4j.Logger;

import java.util.List;

public class Administrate {
    private static final Logger LOGGER = Logger.getLogger(Administrate.class);
    private static Administrate INSTANCE;

    private DAOFactory factory;

    private Administrate() {
        factory = new Factory();
    }

    /**
     * Singleton
     *
     * @return INSTANCE
     */
    public static Administrate getInstance() {
        if (INSTANCE == null) {
            synchronized (Administrate.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Administrate();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Method give us list of all users
     *
     * @return userList
     */
    public List<User> getListUsers() {
        List<User> userList = factory.getUserDao().getAll();
        if (userList == null) {
            LOGGER.info("Your users list is empty");
        }
        return userList;
    }

    /**
     * Method for update user
     *
     * @param user object that you want to change in position id
     * @param id   position of object that you want change
     */
    public void updateUser(User user, int id) {
        factory.getUserDao().update(user, id);
    }

    /**
     * Method for deleting user
     *
     * @param user
     */
    public void deleteUser(User user, int id) {
        factory.getUserDao().delete(id);
    }

    /**
     * Method for create activity
     *
     * @param activity
     */
    public void createActivity(Activity activity) {
        factory.getActivityDao().create(activity);
    }

    /**
     * Method for update activity
     *
     * @param activity object that you want to change in position id
     * @param id       position of object that you want change
     */
    public void updateActivity(Activity activity, int id) {
        factory.getActivityDao().update(activity, id);
    }

    /**
     * Method for delete activity
     *
     * @param id position of object that you want delete
     */
    public void deleteActivity(int id) {
        factory.getActivityDao().delete(id);
    }

    /**
     * Method to get activity
     *
     * @param id position of object that you want get
     */
    public Activity getActivity(int id) {
        return factory.getActivityDao().getById(id);
    }

    /**
     * Method to get all activity
     */
    public List<Activity> getActivities() {
        return factory.getActivityDao().getAll();
    }


    /**
     * These methods for work with Track
     * Method for create track
     *
     * @param track
     */
    public void createTrack(Track track) {
        factory.getTrackDao().create(track);
    }

    /**
     * Method for update track
     *
     * @param track object that you want to change in position id
     * @param id    position of object that you want change
     */
    public void updateTrack(Track track, int id) {
        factory.getTrackDao().update(track, id);
    }

    /**
     * Method for delete track
     *
     * @param id position of object that you want delete
     */
    public void deleteTrack(int id) {
        factory.getTrackDao().delete(id);
    }

    /**
     * Method to get track
     *
     * @param id position of object that you want get
     */
    public Track getTrack(int id) {
        return factory.getTrackDao().getById(id);
    }

    /**
     * Method to get all track
     */
    public List<Track> getTrack() {
        return factory.getTrackDao().getAll();
    }


    /**
     * These methods for work with Request
     * Method for create request
     *
     * @param request
     */
    public void createRequest(Request request) {
        factory.getRequestDao().create(request);
    }

    /**
     * Method for update request
     *
     * @param request object that you want to change in position id
     * @param id      position of object that you want change
     */
    public void updateRequest(Request request, int id) {
        factory.getRequestDao().update(request, id);
    }

    /**
     * Method for delete request
     *
     * @param id position of object that you want delete
     */
    public void deleteRequest(int id) {
        factory.getRequestDao().delete(id);
    }

    /**
     * Method to get request
     *
     * @param id position of object that you want get
     */
    public Request getRequest(int id) {
        return factory.getRequestDao().getById(id);
    }

    /**
     * Method to get all request
     */
    public List<Request> getRequest() {
        return factory.getRequestDao().getAll();
    }
}

