<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2/23/2024
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h1>Sign Up</h1>
<form method="post" action="${pageContext.request.contextPath}/registerServlet">
    <div>
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required="required"/>
    </div>
    <br/>
    <div>
        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" id="lastName" required="required"/>
    </div>
    <br/>
    <div>
        <label for="birthday">Date Of Birth:</label>
        <input type="date" name="birthday" id="birthday" required="required"/>
    </div>
    <br/>
    <div>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required="required"/>
    </div>
    <br/>
    <div>
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" name="confirmPassword" id="confirmPassword" required="required"/>
    </div>
    <br/>
    <div>
        <p>${error}</p>
        <input type="submit" value="Enter">
    </div>
</form>
</body>
</html>
