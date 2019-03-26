package edu.TimeTracker.Java_external.persistence.entity;



import java.sql.Time;
import java.util.Objects;

public class Track {
    private int trackID;
    private Activity activity;
    private boolean active;
    private boolean completed;
    private Time elapsedTime;
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return trackID == track.trackID &&
                active == track.active &&
                completed == track.completed &&
                activity.equals(track.activity) &&
                elapsedTime.equals(track.elapsedTime) &&
                user.equals(track.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackID, activity, active, completed, elapsedTime, user);
    }
}
