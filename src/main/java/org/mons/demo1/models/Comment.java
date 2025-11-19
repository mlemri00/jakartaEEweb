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
    private String comment_text;
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    public Comment(){

    }
    public Comment (long id, String comment){
        this.id=id;
        this.comment_text=comment;

    }


    public long getId() {
        return id;
    }
    public String getComment(){
        return comment_text;
    }

    public Movie getMovie(){
        return movie;
    }


}
