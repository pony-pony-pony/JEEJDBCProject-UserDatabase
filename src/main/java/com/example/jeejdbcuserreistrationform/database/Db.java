package com.example.jeejdbcuserreistrationform.database;

import com.example.jeejdbcuserreistrationform.models.User;

import java.sql.*;

public class Db {
    private static final String url = "jdbc:mysql://localhost:3306/Users";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection connection;
    private static Statement statement;

    public static void connect() {
        try {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                init();
                connection = DriverManager.getConnection(url, user, password);
            }
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void init() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/",
                user,
                password
        );
        statement = connection.createStatement();
        try {
            statement.executeUpdate("create database Users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        close();

        connect();
        try {
            statement.executeUpdate("create table users" +
                    "(login varchar(255) not null," +
                    "first_name varchar(255), " +
                    "last_name varchar(255), " +
                    "birthday date," +
                    "password varchar(255)," +
                    "primary key (login))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        close();
    }


    public static boolean checkLogin(String login) {
        try {
            ResultSet res = statement.executeQuery(String.format("select login from users where login = '%s'", login));
            return res.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkPassword(String login, String password) {
        try {
            ResultSet res = statement.executeQuery(String.format("select login from users where login = '%s' and password ='%s'", login, password));
            return res.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void addUser(String name, String lastName, String birthday, String password, String login) {
        try {

            String values = String.format("'%s', '%s', '%s', '%s','%s'", login, name, lastName, birthday, password);
            System.out.println(values);
            statement.executeUpdate(String.format("insert into users values (%s);", values));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String login) {
        try {
            ResultSet res = statement.executeQuery(String.format("select * from users where login = '%s'", login));

            if (res.next())
                return new User(res.getString("first_name"), res.getString("last_name"),
                        res.getString("birthday"), res.getString("login"));
            else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
