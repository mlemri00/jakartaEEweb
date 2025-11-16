package org.mons.demo1.DAO;

import org.mons.demo1.models.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> getMovies();
    public Movie getById(int id);
    public boolean addMovie(Movie movie);
    public Movie deleteMovieById(int id);

}
