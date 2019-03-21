package edu.TimeTracker.Java_external.entity;

public class Request {
    private int requestId;
    private Type type;
    private Activity activity;
    private User user;

/*    public Request(int requestId, Type type, Activity activity, User user) {
        this.requestId = requestId;
        this.type = type;
        this.activity = activity;
        this.user = user;
    }*/

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public enum Type {
        ADD("ADD"),DELETE("DELETE");
        private String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
