package ch.zuehlke.fullstack.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long locationID;

    private String zip;
    private String name;


    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationID(Long locationID) {
        this.locationID = locationID;
    }

    public Long getLocationID() {
        return locationID;
    }
}
