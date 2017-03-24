<%-- 
    Document   : login
    Created on : Nov 18, 2016, 9:59:05 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Log In</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Log In</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li> 
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/login">Log In</a></li>
                </ul>    
            </div>
            <h2>Login</h2>
            <!-- if login_error == 1 then there was a failed login attempt -->
            <c:if test="${param.login_error == 1}">
                <h3>Wrong id or password!</h3>
            </c:if>
            <form method="post" class="signin" action="j_spring_security_check">
                <fieldset>
                    <div class="form-group">
                        <label for="username" class="control-label">Username</label>
                        <div>    
                            <input id="username_or_email"
                                       name="j_username"
                                       type="text" />
                        </div>
                    <div class="form-group">
                        <label for="password" class="control-label">Password</label>
                        <div>
                            <!-- #2b - must be j_password for Spring -->
                            <input id="password"
                                       name="j_password"
                                       type="password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                        <input name="commit" type="submit" value="Sign In" />
                        </div>
                    </div>    
                </fieldset>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
