package org.mons.demo1;

public class Movie {
    private long id;
    private String name;
    private String description;
    private int year;

    public Movie(long id, String name, String description, int year){
        this.id = id;
        this.name = name;
        this.description= description;
        this.year=year;
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
