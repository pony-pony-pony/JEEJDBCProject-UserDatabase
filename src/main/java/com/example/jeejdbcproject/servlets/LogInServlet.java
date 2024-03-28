package com.example.jeejdbcproject.servlets;

import com.example.jeejdbcproject.database.Db;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.jeejdbcproject.utils.INPUT_ERROR.EMPTY_FIELD;
import static com.example.jeejdbcproject.utils.INPUT_ERROR.USER_DOES_NOT_EXIST;

@WebServlet(name = "logInServlet", value = "/logIn")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Db.connect();
        if (login == null || password == null || login.isBlank() || password.isBlank()) {
            req.setAttribute("error", EMPTY_FIELD.message);
            doGet(req, resp);
        } else if (!Db.checkLogin(login)) {
            req.setAttribute("error", USER_DOES_NOT_EXIST.message);
            doGet(req, resp);
        } else if (!Db.checkPassword(login, password)) {
            req.setAttribute("error", USER_DOES_NOT_EXIST.message);
            doGet(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/profile/" + login).forward(req, resp);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/logIn.jsp").forward(request, response);
    }
}