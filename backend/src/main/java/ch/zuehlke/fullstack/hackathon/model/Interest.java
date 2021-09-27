package ch.zuehlke.fullstack.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interest {

    private String name;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
