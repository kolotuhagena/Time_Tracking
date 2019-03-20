package edu.TimeTracker.Java_external.entity;

import java.sql.Time;

public class Track {
    private int trackID;
    private Activity activity;
    private boolean active;
    private boolean completed;
    private Time elapsedTime;

    public Track(int trackID, Activity activity, boolean active, boolean completed, Time elapsedTime) {
        this.trackID = trackID;
        this.activity = activity;
        this.active = active;
        this.completed = completed;
        this.elapsedTime = elapsedTime;
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Time getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Time elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
