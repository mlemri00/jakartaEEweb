package org.mons.demo1.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Transient private int year;


    public Movie(long id, String name, String description, int year){
        this.id = id;
        this.name = name;
        this.description= description;
        this.year=year;
    }

    public Movie() {

    }

    public long getId(){
        return  id;
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    public int getYear(){
       return year;
    }
}
