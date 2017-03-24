<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <style>
            #title, #dateString, p {
                text-align: center;
            }
            img, #submitButton, #cancelButton {
                display: block;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Home Page</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Back to Main Site</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/portalHome">Portal Home</a></li>                     
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayCreateBlogPost">Create New Blog Post</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createStaticPage">Create New Static Page</a></li>                    
                    <li role="presentation"><a href="${pageContext.request.contextPath}/pendingApproval">Pending Blog Posts</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>                   
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/createNewUser">Create New User</a></li>
                    </sec:authorize>  
                </ul>    
            </div>
        </div>
        <div>
            <h4 id="dateString"><c:out value="${blogPost.date}"/></h4>
            <h1 id="title"><c:out value="${blogPost.title}"/></h1>
            <img src="${pageContext.request.contextPath}/images/${previewPost.imagePath}">
            <p><c:out value="${blogPost.blogText}" escapeXml="false"/></p>
            <p>Categories: <c:out value="${blogPost.categoryString}"/></p>
            <p>Tags: <c:out value="${blogPost.tagString}"/></p>

        <form action="confirmBlogPost" method="POST">
            <div hidden="true">
                <input value="${previewPost.title}" name="title">
                <input value="${previewPost.blogText}" name="blogText">
                <input value="${previewPost.imagePath}" name="imagePath">
                <input value="${previewPost.tagString}" name="tagString">
                <input value="${previewPost.categoryString}" name="categoryString">
            </div>            
            <div class="form-group">
                <input type="submit" value="Submit" id="submitButton">
            </div>
        </form>
        <form action="displayCreateBlogPost" method="GET">
            <div class="form-group" id="cancelButtonDiv">
                <input type="submit" value="Cancel" id="cancelButton">
            </div>
        </form>    
    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>

