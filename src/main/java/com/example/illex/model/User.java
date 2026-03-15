package com.example.illex.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(name = "password_hash", nullable=false)
    private String passwordHash;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Goal> goals;
    
    public User(){}

    public Long getId() {return id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword(){return passwordHash;}
    public void setPassword(String password){this.passwordHash = password;}

}
