package org.mons.demo1.services;

import jakarta.persistence.EntityManager;
import org.mons.demo1.models.Movie;
import org.mons.demo1.util.ConnectionManager;

import java.util.List;

public class MovieServiceOrmImpl implements MovieService{
    @Override
    public List<Movie> getMovies() {
       EntityManager em = ConnectionManager.getEntityManager();
       List<Movie> movies = em.createQuery("select m from Movie m",Movie.class).getResultList();
       em.close();
       return movies;
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
        EntityManager em = ConnectionManager.getEntityManager();
        em.persist(movie);

        String name = movie.getTitle();
        em.clear();
        Movie movie1 = em.createQuery("select m from Movie m where m.title = :name", Movie.class)
                .setParameter("name",name).getSingleResult();

        if (!movie1.getTitle().isEmpty()){
            return true;
        }
        em.close();



        return false;



    }

    @Override
    public Movie deleteMovieById(int id) {
        EntityManager em = ConnectionManager.getEntityManager();
        Movie movie = em.find(Movie.class,id) ;
        if (!movie.getTitle().isEmpty()){
            em.clear();

            em.remove(movie);
            em.close();
        }
        return movie;
    }
}
