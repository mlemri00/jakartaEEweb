package org.mons.demo1.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.mons.demo1.models.Movie;
import org.mons.demo1.util.ConnectionManager;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceOrmImpl implements MovieService{
    @Override
    public List<Movie> getMovies() {
       EntityManager em = ConnectionManager.getEntityManager();
        return new ArrayList<Movie>();
    }

    @Override
    public Movie getById(int id) {
        EntityManager em = ConnectionManager.getEntityManager();
        Movie movie = em.find(Movie.class, id);
        em.close();
        return movie;
    }

    @Override
    public boolean addMovie(Movie movie) {
        return false;
    }

    @Override
    public Movie deleteMovieById(int id) {
        return null;
    }
}
