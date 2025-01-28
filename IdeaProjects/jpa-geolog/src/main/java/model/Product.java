package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Value> values = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;


}
