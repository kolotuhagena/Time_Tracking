package edu.time_tracker.java_external.controllers;

import edu.time_tracker.java_external.domain.entity.Track;
import edu.time_tracker.java_external.repository.TrackRepo;
import edu.time_tracker.java_external.service.TrackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/track")
public class TrackController {

    TrackService trackService;
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


}
