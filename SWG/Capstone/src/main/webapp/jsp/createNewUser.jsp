<%-- 
    Document   : createNewUser
    Created on : Dec 5, 2016, 10:37:56 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New User</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Create New User</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Back to Main Site</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/portalHome">Portal Home</a></li>                        
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayCreateBlogPost">Create New Blog Post</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createStaticPage">Create New Static Page</a></li>   
                    <li role="presentation"><a href="${pageContext.request.contextPath}/pendingApproval">Pending Blog Posts</a></li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/createNewUser">Create New User</a></li>
                    </sec:authorize>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>    
                </ul>    
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <h2>New User</h2>
                    <!-- if login_error == 1 then there was a failed login attempt -->
                    <c:if test="${param.login_error == 1}">
                        <h3>Wrong id or password!</h3>
                    </c:if>
                    <form method="POST" action="addUser">
                        <fieldset>
                            <div class="form-group">
                                <label for="username" class="control-label">Username</label>
                                <div>    
                                    <input type="text" name="username"required/>
                                </div>
                            <div class="form-group">
                                <label for="password" class="control-label">Password</label>
                                <div>
                                    <input type="text" name="password" required/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label">Admin User?</label>
                                <div>
                                    <input type="checkbox" name="isAdmin" value="yes"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div>
                                    <input type="submit" value="Add User"/>
                                </div>
                            </div>    
                        </fieldset>   
                    </form>
                </div>
                <div class="col-sm-6">
                    <h2>List of Admins & Moderators</h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th width="30%">Username</th>
                                <th width="65%">Authorities</th>
                                <th width="5%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td><c:out value="${user.username}"/></td>
                                    <td><c:out value="${user.authority}"/></td>
                                    <td><a href="deleteUser?username=${user.username}" onclick="return confirm('Permanently delete ${user.username}?')">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>