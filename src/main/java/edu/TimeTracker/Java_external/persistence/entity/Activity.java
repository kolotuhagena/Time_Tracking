package edu.TimeTracker.Java_external.persistence.entity;


import java.util.Objects;

public class Activity   {
    private int activityId;
    private String name;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return activityId == activity.activityId &&
                name.equals(activity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, name);
    }
}
