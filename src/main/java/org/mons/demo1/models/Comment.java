package org.mons.demo1.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String commentText;
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;
    public Comment(){

    }
    public Comment (long id, String comment,Movie movie){
        this.id=id;
        this.commentText=comment;
        this.movie=movie;
    }


    public long getId() {
        return id;
    }
    public String getComment(){
        return commentText;
    }

    public Movie getMovie(){
        return movie;
    }


}
