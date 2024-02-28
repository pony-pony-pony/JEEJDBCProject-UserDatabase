package com.example.jeejdbcprojectuserdatabase;

import Models.User;
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
        System.out.println("GET in ProfileServlet");
        System.out.println(request.getParameter("name"));
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
        System.out.println("POST in ProfileServlet");
        doGet(request, response);
    }
}