package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.PrimitiveIterator;

@Getter
@Setter

@Entity
@Table(name = "values")
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Category category;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
