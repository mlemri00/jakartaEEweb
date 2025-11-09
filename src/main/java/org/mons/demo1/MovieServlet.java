package org.mons.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="movieServlet",value = "/movies")
public class MovieServlet extends HttpServlet {

    private final List<Movie> movies = MovieService.getMovies();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("movies", movies);

        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }
}
