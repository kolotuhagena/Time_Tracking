package edu.timeTracker.java_external.service;

import edu.timeTracker.java_external.domain.entity.Request;
import edu.timeTracker.java_external.domain.entity.Track;
import edu.timeTracker.java_external.repository.RequestRepo;
import edu.timeTracker.java_external.repository.TrackRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public class Administrate {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private TrackRepo trackRepo;

    public void response(int id, Object action) {
        Optional<Request> request = requestRepo.findById(id);
        String act = (String) action;
        Request.Type type;
        if (request.isPresent()) {
            type = request.get().getType();
            if (act.toUpperCase().equals("TRUE")) {
                if (type.equals(Request.Type.ADD)) {
                    Track track = new Track();
                    track.setActivity(request.get().getActivity());
                    track.setUser(request.get().getUser());
                    track.setElapsedTime(new Time(0));
                    track.setActive(true);
                    track.setCompleted(false);

                    trackRepo.save(track);
                    requestRepo.delete(request.get());


                } else if (type.equals(Request.Type.DELETE)) {
                    try {
                        trackRepo.deleteById(id);
                    } catch (Exception e) {
                        LOGGER.error("DB haven't such object");
                    }

                }
            }
        }
    }

    public List<Request> getRequest() {
        return requestRepo.findAll();
    }

    public long getRequestRecords() {
        return requestRepo.count();
    }
}

