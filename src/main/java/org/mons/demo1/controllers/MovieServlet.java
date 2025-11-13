package org.mons.demo1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.demo1.models.Movie;
import org.mons.demo1.services.MovieServiceOrmImpl;
import org.mons.demo1.util.jdbcConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="movieServlet",value = "/movies")
public class MovieServlet extends HttpServlet {
    MovieServiceOrmImpl MSOI = new MovieServiceOrmImpl();



    private void showMovie(String id,HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        int idInt = Integer.parseInt(id);


        Movie movie = MSOI.getById(idInt);
        req.setAttribute("movie",movie);
        req.getRequestDispatcher("/movie.jsp").forward(req,resp);

    }

    private void showAllMovies(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movies = MSOI.getMovies();

        req.setAttribute("movies",movies);
        req.getRequestDispatcher("/movies.jsp").forward(req,resp);


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");
        if (id!=null){
            showMovie(id, request,response);
        }else {
            showAllMovies(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String title;
       String description;
       int year;


       try{
           title = req.getParameter("title").trim();
           description =  req.getParameter("description").trim();
           year = Integer.parseInt(req.getParameter("year").trim());

           if (!title.isEmpty() && !description.isEmpty() && year != 0) {
               MSOI.addMovie(
                       new Movie(0L, title, description, year)
               );
           }
       }catch (NumberFormatException e){
           resp.sendError(403,"Aprende escribir anda");
       }
       resp.sendRedirect("movies");

    }
}
