package ch.zuehlke.fullstack.hackathon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Interest {
    @Id
    @GeneratedValue
    private Long interestID;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "hasInterests",
            joinColumns = @JoinColumn(name = "interestID", referencedColumnName = "interestID"),
            inverseJoinColumns = @JoinColumn(name = "userID", referencedColumnName = "userID"))
    private Collection<User> userCollection;
}
