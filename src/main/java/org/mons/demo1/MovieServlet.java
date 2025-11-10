package org.mons.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="movieServlet",value = "/movies")
public class MovieServlet extends HttpServlet {

    private final List<Movie> movies = MovieService.getMovies();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("movies", movies);

        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }
    private void showAllMovies(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {


        try{

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection conn = DriverManager.getConnection("jdbc:mysql://db:3306/movies","root","secret");
        PreparedStatement pst = conn.prepareStatement("select * from movies where name like = ? ");
        pst.setString(1,"rings");

        req.setAttribute("movies",movies);
        req.getRequestDispatcher("/movies.jsp").forward(req,resp);


    }



}
