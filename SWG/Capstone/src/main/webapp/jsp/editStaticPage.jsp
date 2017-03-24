<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Static Page</title>
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
            <h1>Edit Static Page</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Back to Main Site</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/portalHome">Portal Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayCreateBlogPost">Create New Blog Post</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/createStaticPage">Edit Static Page</a></li>                    
                    <li role="presentation"><a href="${pageContext.request.contextPath}/pendingApproval">Pending Blog Posts</a></li>
                    <sec:authorize access="${isAdmin}">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createNewUser">Create New User</a></li>
                    </sec:authorize>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>
                </ul>    
            </div>
            <form action="confirmEditStaticPage" method="POST">
                <div class="form-group">
                    <label for="title">Static Page Title</label>
                    <input type="text" class="form-control" id="static-page-title" name="title" placeholder="Title" value="${staticPage.title}">
                </div>
                <div class="form-group">
                    <label for="content">Static Page Content</label>
                    <textarea class="form-control" id="static-page-content" name="staticPageText">${staticPage.staticPageText}</textarea>
                </div>
                <div class="form-group">
                    <label for="title">External Image Path</label>
                    <input type="text" class="form-control" id="static-page-title" name="imagePath" placeholder="ex. http://i.imgur.com/abD9Xnp.jpg" value="${staticPage.imagePath}">
                </div>
                <c:choose>
                    <c:when test="${isAdmin}">
                        <div class="form-group">
                            <c:if test="${staticPage.isApproved == 0}">
                                <input type="checkbox" name="isApproved" value="1"> <strong>APPROVE POST FOR PUBLISH</strong>
                            </c:if>
                            <c:if test="${staticPage.isApproved == 1}">
                                <input type="checkbox" checked="checked" name="isApproved" value="1"> <strong>APPROVE POST FOR PUBLISH</strong>
                            </c:if>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="isApproved" value="0">
                    </c:otherwise>
                </c:choose>
                <div class="form-group">
                    <input type="hidden" name="displayOrder" value="${staticPage.displayOrder}">
                    <input type="hidden" name="staticPageId" value="${staticPage.staticPageId}">
                    <input type="submit" value="Submit"> <input type="reset" value="Reset">
                </div>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
