package edu.TimeTracker.Java_external.entity;

public class Activity {
    private int activityId;
    private String name;

    public Activity(int activityId, String name) {
        this.activityId = activityId;
        this.name = name;
    }

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

}
