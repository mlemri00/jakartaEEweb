package org.mons.demo1.DTO;

import org.mons.demo1.models.Movie;

public class MovieDTO {
    private String title;
    private String description;
    private int year;

    public MovieDTO(Movie movie){
        this.description=movie.getDescription();
        this.title= movie.getTitle();
        this.year=movie.getYear();
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



}
