package org.mons.demo1.services;

import jakarta.persistence.EntityManager;
import org.mons.demo1.DAO.MovieORMImpl;
import org.mons.demo1.DAO.MovieService;
import org.mons.demo1.DTO.CommentDTO;
import org.mons.demo1.DTO.MovieDTO;
import org.mons.demo1.models.Comment;
import org.mons.demo1.models.Movie;
import org.mons.demo1.util.ConnectionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl {

    MovieService dataRaw = new MovieORMImpl();



    public List<MovieDTO> getMovies() {
        return dataRaw.getMovies().stream().map(MovieDTO::new).collect(Collectors.toList());
    }


    public MovieDTO getById(int id) {
        MovieDTO movieDTO  =new  MovieDTO(dataRaw.getById(id));
        movieDTO.setComments(getComments(id));
        return movieDTO;
    }


    public boolean addMovie(MovieDTO movieDTO) {
        Movie movie = dtoToMovie(movieDTO);

        boolean movieAdded = dataRaw.addMovie(movie);

        return movieAdded;
    }


    public MovieDTO deleteMovieById(int id) {
        return new MovieDTO(dataRaw.deleteMovieById(id));
    }

    public boolean updateMovie(MovieDTO movieDTO){
        boolean updated = ((MovieORMImpl)dataRaw).updateMovie(dtoToMovie(movieDTO));
        return updated;
    }


    private Movie dtoToMovie(MovieDTO DTO){
        return new Movie(DTO.getId(), DTO.getTitle(), DTO.getDescription(), DTO.getYear(),new ArrayList<Comment>());
    }


    public List<CommentDTO> getComments(int movieId){
        return ((MovieORMImpl)dataRaw).movieComments(movieId).stream().map(CommentDTO::new).collect(Collectors.toList());
    }




}
