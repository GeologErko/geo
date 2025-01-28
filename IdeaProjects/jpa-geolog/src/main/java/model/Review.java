package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="reviews")


public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String text;

    private boolean published;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

}
