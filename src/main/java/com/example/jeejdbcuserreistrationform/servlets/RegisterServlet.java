package com.example.jeejdbcuserreistrationform.servlets;

import com.example.jeejdbcuserreistrationform.database.Db;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.jeejdbcuserreistrationform.utils.INPUT_ERROR.LOGIN_ALREADY_EXISTS;
import static com.example.jeejdbcuserreistrationform.utils.INPUT_ERROR.PASSWORD_DO_NOT_MATCH;

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
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        Db.connect();
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", PASSWORD_DO_NOT_MATCH.message);
            doGet(request, response);
        } else if (Db.checkLogin(login)) {
            request.setAttribute("error", LOGIN_ALREADY_EXISTS.message);
            doGet(request, response);
        } else {
            Db.addUser(name, lastName, birthday, password, login);
            Db.close();
            getServletContext().getRequestDispatcher("/profile/" + login).forward(request, response);
        }
    }
}