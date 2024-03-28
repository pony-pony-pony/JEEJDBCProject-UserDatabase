package com.example.jeejdbcproject.servlets;

import com.example.jeejdbcproject.database.Db;
import com.example.jeejdbcproject.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "profileServlet", value = "/profile/*")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("name") == null) {
            Db.connect();
            request.setAttribute("user", Db.getUser(request.getParameter("login")));
            Db.close();
        } else {
            request.setAttribute("user", new User(
                    request.getParameter("name"), request.getParameter("lastName"),
                    request.getParameter("birthday"), request.getParameter("login")
            ));
        }
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}