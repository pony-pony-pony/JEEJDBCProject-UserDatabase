package com.example.jeejdbcprojectuserdatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.example.jeejdbcprojectuserdatabase.INPUT_ERROR.PASSWORD_DO_NOT_MATCH;
import static com.example.jeejdbcprojectuserdatabase.INPUT_ERROR.USER_DOES_NOT_EXIST;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String birthday = request.getParameter("birthday");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", PASSWORD_DO_NOT_MATCH.message);
            doGet(request, response);
        } else {
            int id = pushToDB(name, lastName, birthday, password, String.valueOf(LocalDateTime.now()));
            response.sendRedirect("/users/profile/" + id);
        }
    }

    // TODO write when db is created
    private int pushToDB(String name, String lastName, String birthday, String password, String signUpDate) {return 0;}
}