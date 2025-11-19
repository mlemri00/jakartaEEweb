package org.mons.dev.models;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "birth_date")
    private Date birthDate;
    private String password;
    public User(String firstName, String lastName, String userName, Date birthDate, String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.birthDate=birthDate;
        this.password=password;

    }

    public User(){

    }


}
