package edu.time_tracker.java_external.domain.entity;


import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Track {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;


    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = false)
    private Time elapsedTime;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
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
        return id.equals(track.id) &&
                active == track.active &&
                completed == track.completed &&
                activity.equals(track.activity) &&
                elapsedTime.equals(track.elapsedTime) &&
                user.equals(track.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activity, active, completed, elapsedTime, user);
    }
}
