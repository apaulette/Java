<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Review Static Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h2>Home Page</h2>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayCreateBlogPost">Create New Blog Post</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayCreateStaticPage">Create New Static Page</a></li>   
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLogin">Log In</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/pendingApproval">Pending Blog Posts</a></li>
                </ul>    
            </div>
        </div>
        <div>
            <h1 id="title"><c:out value="${previewPost.title}"/></h1>
            <div><c:out value="${previewPost.staticPageText}" escapeXml="false"/></div>

            <form action="confirmStaticPage" method="POST">
                <input value="${previewPost.title}" name="title" type="hidden">
                <input value="${previewPost.staticPageText}" name="blogText" type="hidden">
                <div class="form-group">
                    <input type="submit" value="Submit">
                </div>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.mi.js"></script>

    </body>
</html>

