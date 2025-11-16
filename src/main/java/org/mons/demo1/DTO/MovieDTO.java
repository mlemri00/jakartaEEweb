package org.mons.demo1.DTO;

import org.mons.demo1.models.Comment;
import org.mons.demo1.models.Movie;

import java.util.List;

public class MovieDTO {
    private long id;
    private String title;
    private String description;
    private int year;
    private List<Comment>comments;

    public MovieDTO(Movie movie){
        this.id= movie.getId();//Falla si no poner id, porqué?????
        this.description=movie.getDescription();
        this.title= movie.getTitle();
        this.year=movie.getYear();
        this.comments= movie.getComments();
    }
    public MovieDTO(long id, String title,String description, int year){
        this.id=id;
        this.title=title;
        this.description=description;
        this.year=year;
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public int getYear(){
        return this.year;
    }
    public List<Comment> getComments(){
        return this.comments;
    }




}
