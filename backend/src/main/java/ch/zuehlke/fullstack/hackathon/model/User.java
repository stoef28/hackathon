package ch.zuehlke.fullstack.hackathon.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userID;

    private String name;
    private String picture;
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="locationID", referencedColumnName = "locationID")
    private Location location;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="hasSkills",
            joinColumns=@JoinColumn(name="userID", referencedColumnName="userID"),
            inverseJoinColumns=@JoinColumn(name="interestID", referencedColumnName="interestID"))
    private Collection<Interest> interestCollection;


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Collection<Interest> getInterestCollection() {
        return interestCollection;
    }

    public void setInterestCollection(Collection<Interest> interestCollection) {
        this.interestCollection = interestCollection;
    }
}
