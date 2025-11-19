package org.mons.demo1.controllers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.demo1.DTO.MovieDTO;
import org.mons.demo1.models.Comment;
import org.mons.demo1.models.Movie;
import org.mons.demo1.DAO.MovieORMImpl;
import org.mons.demo1.services.MovieServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebFilter("/movies")
@WebServlet(name="movieServlet",value = "/movies")
public class MovieServlet extends HttpServlet implements Filter {
     MovieServiceImpl MSOI = new MovieServiceImpl();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("post")){
            String method =  req.getParameter("_method");
            switch (method){
                case "delete" -> doDelete(req, resp);
                case "put" -> doPut(req, resp);
                case "post" -> doPost(req, resp);
                default -> {
                    return;
                }
            }
        }else {
            super.service(req, resp);
        }
    }

    private void showMovie(String id, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        int idInt = Integer.parseInt(id);


        MovieDTO movie = MSOI.getById(idInt);

        req.setAttribute("movie",movie);
        req.getRequestDispatcher("/movie.jsp").forward(req,resp);

    }

    private void showAllMovies(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MovieDTO> movies = MSOI.getMovies();

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
               MSOI.addMovie(new MovieDTO(0L, title, description, year));

           }
           resp.sendRedirect("movies");
       }catch (Exception e){
        resp.sendRedirect("error");
       }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id  = Integer.parseInt(req.getParameter("id"));
        MSOI.deleteMovieById(id);

        req.removeAttribute("id");
        resp.sendRedirect("movies");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDTO movie = new MovieDTO(
               Long.parseLong(req.getParameter("id")),
                req.getParameter("title"),
                req.getParameter("description"),
               Integer.parseInt(req.getParameter("year"))
        );

        MSOI.updateMovie(movie);

        resp.sendRedirect("movies");


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  request  = (HttpServletRequest)  servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        if (session == null){
            response.sendRedirect("/login");
        }
    }
}
