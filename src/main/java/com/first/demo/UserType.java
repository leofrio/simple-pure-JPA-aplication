package com.first.demo;

import javax.persistence.*;
//added this just to learn wont be used on the coffee database
@Entity
@Table(name = "user_types")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType() {
    }

    public UserType(String name) {
        this.name = name;
    }
}
