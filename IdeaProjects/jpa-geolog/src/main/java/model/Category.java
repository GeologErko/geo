package model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "categories")

public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<Option>options = new ArrayList<>();


}
