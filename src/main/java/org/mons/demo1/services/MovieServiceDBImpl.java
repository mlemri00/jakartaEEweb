package org.mons.demo1.services;

import org.mons.demo1.models.Movie;
import org.mons.demo1.util.jdbcConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MovieServiceDBImpl implements MovieService{

    private List<Movie> movies;
    private Connection connection = jdbcConnector.getConnection();

    private void retrieveAllMovies(){
        PreparedStatement pst;
        ResultSet result;
        try {
             pst = connection.prepareStatement("SELECT * FROM movies ");
             result = pst.executeQuery();

        } catch (SQLException sqlException){
            System.out.println("No se pudo ejecutar la conexión con la bases de datos");
        }


    }
    @Override
    public List<Movie> getMovies() {
        return List.of();
    }

    @Override
    public Movie getById(int id) {
        return null;
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
