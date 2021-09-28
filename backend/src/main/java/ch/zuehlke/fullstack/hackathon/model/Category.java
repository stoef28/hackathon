package ch.zuehlke.fullstack.hackathon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    private Long categoryID;

    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Collection<Interest> interests;
}
