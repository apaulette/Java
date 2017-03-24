<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Static Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce-init.js"></script>

    </head>
    <body>
        <sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
        <sec:authorize access="hasRole('ROLE_MODERATOR')" var="isModerator" />
        <div class="container">
            <h1>Create New Static Page</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Back to Main Site</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/portalHome">Portal Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayCreateBlogPost">Create New Blog Post</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/createStaticPage">Create New Static Page</a></li>                    
                    <li role="presentation"><a href="${pageContext.request.contextPath}/pendingApproval">Pending Blog Posts</a></li>
                    <sec:authorize access="${isAdmin}">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createNewUser">Create New User</a></li>
                    </sec:authorize>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>
                </ul>    
            </div>
            <form action="postStaticPage" method="POST">
                <div class="form-group">
                    <label for="title">Static Page Title</label>
                    <input type="text" class="form-control" id="static-page-title" name="title" placeholder="Title" required>
                </div>
                <div class="form-group">
                    <label for="content">Static Page Content</label>
                    <textarea class="form-control" id="static-page-content" name="staticPageText">Post content</textarea>
                </div>
                <div class="form-group">
                    <label for="title">Image Name (located on server)</label>
                    <input type="text" class="form-control" id="static-page-title" name="imagePath" placeholder="ex. lotsOfCookies.jpg">
                </div>
                <c:choose>
                    <c:when test="${isAdmin}">
                        <div class="form-group">
                        <input type="checkbox" name="isApproved" value="1"> <strong>APPROVE POST FOR PUBLISH</strong>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="isApproved" value="0">
                    </c:otherwise>
                </c:choose>
                <div class="form-group">
                    <c:choose>
                        <c:when test="${not empty staticPageLinks}">
                            <c:set var="displayPositionNumber" scope="page" value="${fn:length(staticPageLinks) + 1}"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="displayPositionNumber" scope="page" value="1"/>
                        </c:otherwise>
                    </c:choose>
                    <input type="hidden" name="displayOrder" value="${displayPositionNumber}">
                    <input type="submit" value="Submit"> <input type="reset" value="Reset">
                </div>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
