package com.example.jeejdbcprojectuserdatabase;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static com.example.jeejdbcprojectuserdatabase.INPUT_ERROR.*;

@WebServlet(name = "logInServlet", value = "/logIn")
public class LogInServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST in LogInServlet");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null || login.isBlank() || password.isBlank()) {
            req.setAttribute("error", EMPTY_FIELD.message);
            doGet(req, resp);
        } else if (!checkLogin(login)) {
            req.setAttribute("error", USER_DOES_NOT_EXIST.message);
            doGet(req, resp);
        } else if(!checkPassword(login, password)) {
            req.setAttribute("error", USER_DOES_NOT_EXIST.message);
            doGet(req, resp);
        } else {
            System.out.println("hey");
            resp.sendRedirect("/users/profile/"+getUserId(login, password));
        }
}


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("GET in LogInServlet");
        getServletContext().getRequestDispatcher("/logIn.jsp").forward(request, response);
    }

    // TODO write when db is created
    private boolean checkLogin(String login) {return true;}
    private boolean checkPassword(String login, String password) { return  true;}
    private int getUserId(String login, String password) { return 0; }

}