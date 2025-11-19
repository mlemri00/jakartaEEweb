package org.mons.dev.DTO;

import org.mons.dev.models.Movie;

import java.util.List;

public class MovieDTO {
    private long id;
    private String title;
    private String description;
    private int year;
    private List<CommentDTO>comments;

    public MovieDTO(Movie movie){
        this.id= movie.getId();//Falla si no poner id, porqué?????
        this.description=movie.getDescription();
        this.title= movie.getTitle();
        this.year=movie.getYear();
        this.comments= movie.getComments().stream().map(CommentDTO::new).toList();
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
    public List<CommentDTO> getComments(){
        return this.comments;
    }
    public void setComments(List<CommentDTO>comments){
        this.comments=comments;
    }

}
