package edu.TimeTracker.Java_external.service.UserService;

import com.sun.deploy.net.HttpRequest;
import edu.TimeTracker.Java_external.persistence.DAO.Factory.DAOFactory;
import edu.TimeTracker.Java_external.persistence.DAO.Factory.Factory;
import org.apache.log4j.Logger;

public class PerformTrack {
    private static final Logger LOGGER = Logger.getLogger(PerformTrack.class);
    private static PerformTrack INSTANCE;

    private DAOFactory factory;

    private PerformTrack() {
        factory = new Factory();
    }

    /**
     * Singleton
     *
     * @return INSTANCE
     */
    public static PerformTrack getInstance() {
        if (INSTANCE == null) {
            synchronized (PerformTrack.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PerformTrack();
                }
            }
        }
        return INSTANCE;
    }

    /**
     *
     */
    public void performTrack(HttpRequest request){
    }
}
