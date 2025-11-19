package org.mons.demo1.services;

import org.mons.demo1.DAO.movie.MovieORMImpl;
import org.mons.demo1.DAO.movie.MovieService;
import org.mons.demo1.DTO.CommentDTO;
import org.mons.demo1.DTO.MovieDTO;
import org.mons.demo1.models.Comment;
import org.mons.demo1.models.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl {

    MovieService DAOserv = new MovieORMImpl();


    public List<MovieDTO> getMovies() {
        return DAOserv.getMovies().stream().map(MovieDTO::new).collect(Collectors.toList());
    }


    public MovieDTO getById(int id) {
        MovieDTO movieDTO  =new  MovieDTO(DAOserv.getById(id));
        return movieDTO;
    }


    public boolean addMovie(MovieDTO movieDTO) {
        Movie movie = dtoToMovie(movieDTO);

        boolean movieAdded = DAOserv.addMovie(movie);

        return movieAdded;
    }


    public MovieDTO deleteMovieById(int id) {
        return new MovieDTO(DAOserv.deleteMovieById(id));
    }

    public boolean updateMovie(MovieDTO movieDTO){
        boolean updated = ((MovieORMImpl)DAOserv).updateMovie(dtoToMovie(movieDTO));
        return updated;
    }


    private Movie dtoToMovie(MovieDTO DTO){
        return new Movie(DTO.getId(), DTO.getTitle(), DTO.getDescription(), DTO.getYear(),new ArrayList<Comment>());
    }


    public List<CommentDTO> getComments(int movieId){
        return ((MovieORMImpl)DAOserv).movieComments(movieId).stream().map(CommentDTO::new).collect(Collectors.toList());
    }




}
