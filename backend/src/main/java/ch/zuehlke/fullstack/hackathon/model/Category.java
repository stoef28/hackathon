package ch.zuehlke.fullstack.hackathon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long categoryID;

    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Collection<Interest> interests;
}
