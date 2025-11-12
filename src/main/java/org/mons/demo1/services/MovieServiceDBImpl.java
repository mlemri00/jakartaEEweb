package org.mons.demo1.services;

import org.mons.demo1.models.Movie;
import org.mons.demo1.util.jdbcConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceDBImpl implements MovieService{

    @Override
    public List<Movie> getMovies() {

        List <Movie> movies = new ArrayList<>();
        PreparedStatement pst;
        ResultSet result;

        try {
            Connection connection = jdbcConnector.getConnection();
            pst = connection.prepareStatement("SELECT * FROM movies ");
            result = pst.executeQuery();

            while(result.next()){
                long movieId = result.getLong("id");
                String movieTitle = result.getString("title");
                String movieDesc = result.getString("description");
                int movieYear= result.getInt("year");

                movies.add(new Movie(movieId,movieTitle,movieDesc,movieYear));
            }
            connection.close();
        } catch (SQLException sqlException){
            System.out.println("No se pudo ejecutar la conexión con la bases de datos");
        }

        return movies;
    }

    @Override
    public Movie getById(int id) {
        Connection connection = jdbcConnector.getConnection();
        Movie movie;

        try{
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM movies where id = ? ");
            pst.setInt(1,id);
            ResultSet result = pst.executeQuery();
            movie = new Movie(
                    result.getLong("id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getInt("year")

            );
            connection.close();
            return movie;

        }catch (SQLException sqlException){
            System.out.println("No se pudo ejecutar la conexión con la bases de datos");

        }
        return new Movie();
    }

    @Override
    public boolean addMovie(Movie movie) {
        Connection connection = jdbcConnector.getConnection();
        int affectedRows = 0;

        try{

            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO movies (title,description, year) VALUES(?,?,?) " );
            pst.setString(1, movie.getName());
            pst.setString(2, movie.getDescription());
            pst.setInt(3, movie.getYear());

            affectedRows = pst.executeUpdate();

        }catch (SQLException sqlException){
            System.out.println("No se pudo ejecutar la conexión con la bases de datos");

        }


        if (affectedRows>0){
            return true;
        }
        return false;




    }

    @Override
    public Movie deleteMovieById(int id) {
        return null;
    }
}
