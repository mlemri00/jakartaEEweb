package org.mons.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="movieServlet",value = "/movies")
public class MovieServlet extends HttpServlet {

    private final List<Movie> movies = new ArrayList<>();



    private void showAllMovies(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {


        try{

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection conn = DriverManager.getConnection("jdbc:mysql://db:3306/movies","root","root8081");
        PreparedStatement pst = conn.prepareStatement("select * from movies;");


        ResultSet result = pst.executeQuery();

        while(result.next()){
            long movieId = result.getLong("id");
            String movieTitle = result.getString("title");
            String movieDesc = result.getString("description");
            int movieYear= result.getInt("year");


            Movie movie = new Movie(movieId,movieTitle,movieDesc,movieYear);
            movies.add(movie);
        }
        conn.close();


        req.setAttribute("movies",movies);
        req.getRequestDispatcher("/movies.jsp").forward(req,resp);


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            showAllMovies(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
