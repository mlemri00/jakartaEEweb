package org.mons.demo1.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;
    public Comment(){

    }
    public Comment (long id, String comment,Movie movie){
        this.id=id;
        this.comment=comment;
        this.movie=movie;
    }


    public long getId() {
        return id;
    }
    public String getComment(){
        return comment;
    }

    public Movie getMovie(){
        return movie;
    }
    @Override
    public boolean equals(Object obj) {
        return ((Movie) obj).getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,comment);
    }

}
