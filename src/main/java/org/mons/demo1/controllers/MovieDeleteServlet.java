package org.mons.demo1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.demo1.services.MovieServiceOrmImpl;

import java.io.IOException;
@WebServlet(name = "delete", value = "delete")
public class MovieDeleteServlet extends HttpServlet {
    MovieServiceOrmImpl MSOI = new MovieServiceOrmImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        MSOI.deleteMovieById(id);
        resp.sendRedirect("movies");

    }
}
