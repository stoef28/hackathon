package ch.zuehlke.fullstack.hackathon.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Interest {


    @Id
    @GeneratedValue
    private Long interestID;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryID", referencedColumnName = "categoryID")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="hasSkills",
            joinColumns=@JoinColumn(name="interestID", referencedColumnName="interestID"),
            inverseJoinColumns=@JoinColumn(name="userID", referencedColumnName="userID"))
    private Collection<User> userCollection;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setInterestID(Long interestID) {
        this.interestID = interestID;
    }

    public Long getInterestID() {
        return interestID;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }
}
