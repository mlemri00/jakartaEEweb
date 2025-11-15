package org.mons.demo1.controllers;

import com.google.protobuf.TextFormat;
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


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("post")){
            String method =  req.getParameter("_method");
            if (method == null){return;}
            switch (method){
                case "delete" -> doDelete(req, resp);
                case "put" -> doPut(req, resp);
                case "post" -> doPost(req, resp);
                default -> {
                    return;
                }
            }
        }else{//Preguntar a Pere, porque si se saca el super.service del else el formulario al recargar la pàgina se reenvia
        super.service(req,resp);
        }
    }

    private void showMovie(String id, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

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
        if (id != null && !id.isBlank()){
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
               MSOI.addMovie(new Movie(0L, title, description, year));

           }



       }catch (NumberFormatException e){
        resp.sendRedirect("error");
       }

       resp.sendRedirect("movies");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id  = Integer.parseInt(req.getParameter("id"));
        MSOI.deleteMovieById(id);

        req.removeAttribute("id");
        resp.sendRedirect("movies");

    }
}
