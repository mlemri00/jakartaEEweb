package org.mons.demo1.DAO;

import jakarta.persistence.EntityManager;
import org.mons.demo1.models.Movie;
import org.mons.demo1.util.ConnectionManager;

import java.util.List;

public class MovieORMImpl implements MovieService{
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
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
        em.close();



        return false;



    }

    @Override
    public Movie deleteMovieById(int id) {
        EntityManager em = ConnectionManager.getEntityManager();

        Movie movie = em.find(Movie.class,id) ;
        if (!movie.getTitle().isEmpty()){
            try {
                em.getTransaction().begin();
                em.remove(movie);
            }catch (Exception e){
                em.getTransaction().rollback();

            }
         em.getTransaction().commit();
        }
        em.close();
        return movie;
    }
}
