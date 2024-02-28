<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2/23/2024
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="tables.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <table>
        <tr>
            <th>Name</th>
            <th>LastName</th>
            <th>Birthday</th>
            <th>Login</th>
        </tr>
        <tr>
            <th>${user.name}</th>
            <th>${user.lastName}</th>
            <th>${user.birthday}</th>
            <th>${user.login}</th>
        </tr>
    </table>
</body>
</html>
