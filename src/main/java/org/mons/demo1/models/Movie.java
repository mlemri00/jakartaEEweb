package org.mons.demo1.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @OneToMany (mappedBy = "movie")
    private List<Comment> comments = new ArrayList<>();


    public Movie(long id, String title, String description, int year,List<Comment>comments){
        this.id = id;
        this.title = title;
        this.description= description;
        this.year=year;
        this.comments=comments;
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
    public List<Comment>getComments(){
        return this.comments;
    }
    public void updateMovie(String title, String description, int year){
        this.title=title;
        this.description=description;
        this.year=year;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Movie) obj).getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,title);
    }
}
