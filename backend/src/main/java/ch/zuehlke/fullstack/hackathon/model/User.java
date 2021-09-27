package ch.zuehlke.fullstack.hackathon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long userID;

    private String pictureId;
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationID", referencedColumnName = "locationID")
    private Location location;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "hasSkills",
            joinColumns = @JoinColumn(name = "userID", referencedColumnName = "userID"),
            inverseJoinColumns = @JoinColumn(name = "interestID", referencedColumnName = "interestID"))
    private Collection<Interest> interestCollection;
}
