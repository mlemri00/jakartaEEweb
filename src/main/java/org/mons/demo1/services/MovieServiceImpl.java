package org.mons.demo1.services;

import org.mons.demo1.DAO.MovieORMImpl;
import org.mons.demo1.DAO.MovieService;
import org.mons.demo1.models.Movie;

import java.util.List;

public class MovieServiceImpl extends MovieService{

    MovieService dataRaw = new MovieORMImpl();


    @Override
    public List<Movie> getMovies() {
        return dataRaw.getMovies();
    }

    @Override
    public Movie getById(int id) {
        return dataRaw.getById(id);
    }

    @Override
    public boolean addMovie(Movie movie) {
        return dataRaw.addMovie(movie);
    }

    @Override
    public Movie deleteMovieById(int id) {
        return dataRaw.deleteMovieById(id);
    }
}
