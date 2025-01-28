package model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_products")


public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



}
