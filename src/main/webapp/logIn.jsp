<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Log in: </h1>
<form method="post" action="${pageContext.request.contextPath}/logIn">
    <div>
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" <%-- required="required" --%> />
    </div>
    <br/>
    <div>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" <%-- required="required" --%> />
    </div>
    <br/>
    <div>
        <p>${error}</p>
        <input type="submit" value="Enter">
    </div>
</form>
Doesn't have an account yet? <a href="${pageContext.request.contextPath}/registerServlet">Sign Up</a>
</body>
</html>