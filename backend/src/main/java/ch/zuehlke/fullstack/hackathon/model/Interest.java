package ch.zuehlke.fullstack.hackathon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
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
            name = "hasSkills",
            joinColumns = @JoinColumn(name = "interestID", referencedColumnName = "interestID"),
            inverseJoinColumns = @JoinColumn(name = "userID", referencedColumnName = "userID"))
    private Collection<User> userCollection;
}
