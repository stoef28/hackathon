package ch.zuehlke.fullstack.hackathon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
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


    public void addInterest(Interest interest) {
        if (this.interests == null)
            this.interests = new ArrayList<>();

        this.interests.add(interest);
    }
}
