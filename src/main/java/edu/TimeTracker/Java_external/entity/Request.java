package edu.TimeTracker.Java_external.entity;

import java.util.Objects;

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
    public void setType(String type){
        if(type.toUpperCase().equals(Type.ADD.getName())) this.type=Type.ADD;
        if(type.toUpperCase().equals(Type.DELETE.getName())) this.type = Type.DELETE;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return requestId == request.requestId &&
                type == request.type &&
                activity.equals(request.activity) &&
                user.equals(request.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, type, activity, user);
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
