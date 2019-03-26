package edu.TimeTracker.Java_external.service;

import edu.TimeTracker.Java_external.persistence.DAO.Factory.DAOFactory;
import edu.TimeTracker.Java_external.persistence.DAO.Factory.Factory;
import edu.TimeTracker.Java_external.persistence.entity.Activity;
import edu.TimeTracker.Java_external.persistence.entity.Request;
import edu.TimeTracker.Java_external.persistence.entity.Track;
import edu.TimeTracker.Java_external.persistence.entity.User;
import org.apache.log4j.Logger;

import java.sql.Time;
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


    public void response(int id, Object action) {
        Request request = factory.getRequestDao().getById(id);
        String act = (String) action;
        Request.Type type = request.getType();
        if (act.toUpperCase().equals("TRUE")) {
            if (type.equals(Request.Type.ADD)) {
                Track track = new Track();
                track.setActivity(request.getActivity());
                track.setUser(request.getUser());
                track.setElapsedTime(new Time(0));
                track.setActive(true);
                track.setCompleted(false);

                factory.getTrackDao().create(track);
                factory.getRequestDao().delete(request.getRequestId());


            } else if(type.equals(Request.Type.DELETE)){
                try {
                    factory.getTrackDao().delete(id);
                }catch (Exception e) {
                    LOGGER.error("DB haven't such object");
                }

            }
        }

    }

    /**
     * Method to get all request
     */
    public List<Request> getRequest(int offset, int records) {
        return factory.getRequestDao().getAllWithPagination(offset, records);
    }

    public int getRequestRecords() {
        return factory.getRequestDao().getCountObjects();
    }
}

