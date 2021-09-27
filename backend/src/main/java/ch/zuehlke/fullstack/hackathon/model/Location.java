package ch.zuehlke.fullstack.hackathon.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue
    private Long locationID;

    private String zip;
    private String name;
}
