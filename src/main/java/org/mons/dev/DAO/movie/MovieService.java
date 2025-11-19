package org.mons.dev.DAO.movie;

import org.mons.dev.models.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> getMovies();
    public Movie getById(int id);
    public boolean addMovie(Movie movie);
    public Movie deleteMovieById(int id);

}
