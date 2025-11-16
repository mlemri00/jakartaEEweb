package org.mons.demo1.DAO;

import jakarta.persistence.EntityManager;
import org.mons.demo1.models.Comment;
import org.mons.demo1.models.Movie;
import org.mons.demo1.util.ConnectionManager;
import org.mons.demo1.util.jdbcConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieJdbcImpl implements MovieService{

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

                movies.add(new Movie(movieId,movieTitle,movieDesc,movieYear,new ArrayList<Comment>()));
            }
            connection.close();
        } catch (SQLException sqlException){
            System.out.println("No se pudo ejecutar la conexión con la bases de datos");
        }

        return movies;
    }

    @Override
    public Movie getById(int id) {
        Movie movie = new Movie();
        ResultSet result;
        try{
            Connection connection = jdbcConnector.getConnection();

            PreparedStatement pst = connection.prepareStatement("SELECT * FROM movies where id = ? ");
            pst.setInt(1,id);
             result = pst.executeQuery();
            movie = new Movie(
                    result.getLong("id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getInt("year")
                    ,new ArrayList<Comment>()

            );
            connection.close();
            return movie;

        }catch (SQLException sqlException){
            System.out.println("No se pudo ejecutar la conexión con la bases de datos");

        }
        r

        return movie;
    }

    @Override
    public boolean addMovie(Movie movie) {
        Connection connection = jdbcConnector.getConnection();
        int affectedRows = 0;

        try{

            PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO movies (title,description, year) VALUES(?,?,?) " );
            pst.setString(1, movie.getTitle());
            pst.setString(2, movie.getDescription());
            pst.setInt(3, movie.getYear());

            affectedRows = pst.executeUpdate();
            connection.close();
        }catch (SQLException sqlException){
            System.out.println("No se pudo ejecutar la conexión con la bases de datos");

        }


        if (affectedRows>0){
            return true;
        }
        return false;

    }

    @Override
    public Movie deleteMovieById(int id){
        Movie movie =  new Movie();
        int affectedRows = 0;
        try{
            Connection connection = jdbcConnector.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM movies where id = ? ");
            pst.setInt(1,id);
            ResultSet result = pst.executeQuery();
            movie = new Movie(
                    result.getLong("id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getInt("year"),
                    new ArrayList<Comment>()
            );
            connection.close();

        }catch (SQLException e){
            System.out.println("No se pudo ejecutar la conexión con la bases de datos");

        }

        try {
            Connection connection = jdbcConnector.getConnection();

            PreparedStatement pst = connection.prepareStatement("DELETE FROM movies where id = ? ");
            pst.setLong(1,id);

            affectedRows =pst.executeUpdate();


            connection.close();
        }catch (SQLException s){

            System.out.println("No se pudo ejecutar la conexión con la bases de datos");

        }

        if (affectedRows>0){
            return movie;
        }
        return movie;


    }
    public boolean updateMovie(Movie movie)  {
        Connection connection = jdbcConnector.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("UPDATE movies set title = ? , description = ?, year = ? where id = ?");
            pst.setString(1, movie.getTitle());
            pst.setString(2, movie.getDescription());
            pst.setInt(3,movie.getYear());
            pst.setLong(4,movie.getId());
            connection.close();
            pst.executeUpdate();

            return true;
        }catch (Exception e){

        }


        return false;
    }
    public List<Comment> movieComments(int movieID){
        List<Comment> comments = new ArrayList<>();
        Connection connection = jdbcConnector.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("select * from comments where movieId = ?");
            pst.setInt(1,movieID);

            ResultSet results = pst.executeQuery();

            while (results.next()){
                comments.add(new Comment(
                        results.getLong("id"),
                        results.getString("commentText")));
            }
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return comments;
    }


}
