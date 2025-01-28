package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
    private String name;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "option")
    private List<Value> values;
}
