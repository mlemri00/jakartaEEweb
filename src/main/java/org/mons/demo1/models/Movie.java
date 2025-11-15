package org.mons.demo1.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    @Column(name = "description")
    private String description;
    private int year;


    public Movie(long id, String title, String description, int year){
        this.id = id;
        this.title = title;
        this.description= description;
        this.year=year;
    }

    public Movie() {

    }

    public long getId(){
        return  id;
    }
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public int getYear(){
       return year;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setYear(int year){
        this.year=year;
    }

    public void updateMovie(String title, String description, int year){
        this.title=title;
        this.description=description;
        this.year=year;
    }

}
