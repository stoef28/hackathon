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

    private String code;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "hasInterests",
            joinColumns = @JoinColumn(name = "userID", referencedColumnName = "userID"),
            inverseJoinColumns = @JoinColumn(name = "interestID", referencedColumnName = "interestID"))
    private Collection<Interest> interests;
}
