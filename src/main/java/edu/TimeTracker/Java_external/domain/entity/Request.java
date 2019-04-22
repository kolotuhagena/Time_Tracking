package edu.TimeTracker.Java_external.domain.entity;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "request")
public class Request  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
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
        return id == request.id &&
                type == request.type &&
                activity.equals(request.activity) &&
                user.equals(request.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, activity, user);
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
