package edu.TimeTracker.Java_external.domain.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "activity")
public class Activity   {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "activity")
    List<Track> trackList;

    @OneToMany(mappedBy = "activity")
    List<Request> requestsList;

    public Long getId() {
        return id;
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
        return id == activity.id &&
                name.equals(activity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
