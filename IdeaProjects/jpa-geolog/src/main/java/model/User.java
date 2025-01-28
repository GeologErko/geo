package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString

@Entity
@Table(name = "users")


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String login;
    private String password;

    @Enumerated
    private UserRole role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;




}
