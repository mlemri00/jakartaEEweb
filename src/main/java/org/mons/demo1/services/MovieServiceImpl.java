package org.mons.demo1.services;

import org.mons.demo1.DAO.MovieORMImpl;
import org.mons.demo1.DAO.MovieService;
import org.mons.demo1.DTO.MovieDTO;
import org.mons.demo1.models.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl {

    MovieService dataRaw = new MovieORMImpl();



    public List<MovieDTO> getMovies() {
        return dataRaw.getMovies().stream().map(MovieDTO::new).collect(Collectors.toList());
    }


    public MovieDTO getById(int id) {
        return new MovieDTO(dataRaw.getById(id));
    }


    public boolean addMovie(Movie movie) {
        boolean movieAdded = dataRaw.addMovie(movie);

        return movieAdded;
    }


    public MovieDTO deleteMovieById(int id) {
        return new MovieDTO(dataRaw.deleteMovieById(id));
    }
}
