package com.hasitha.springbootsecurity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="role")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String roll;


    @ManyToMany(mappedBy = "roles" , fetch = FetchType.EAGER)
    private List<User> users= new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}
