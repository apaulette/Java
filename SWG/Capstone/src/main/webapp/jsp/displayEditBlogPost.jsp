<%-- 
    Document   : createBlogPost
    Created on : Nov 18, 2016, 10:02:15 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Post</title>
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
            <h1>Edit Post</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation"><a href="${pageContext.request.contextPath}/home">Back to Main Site</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/portalHome">Portal Home</a></li>                        
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayCreateBlogPost">Edit Blog Post</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/createStaticPage">Create New Static Page</a></li>   
                        <li role="presentation"><a href="${pageContext.request.contextPath}/pendingApproval">Pending Blog Posts</a></li> 
                        <sec:authorize access="${isAdmin}">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/createNewUser">Create New User</a></li>
                        </sec:authorize>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>
                </ul>    
            </div>
            <form action="confirmEditBlogPost" method="POST">
                <div class="form-group">
                    <label for="title">Blog Post Title</label>
                    <input type="text" class="form-control" id="blog-post-title" name="title" value="${blogPost.title}">
                </div>
                <div class="form-group">
                    <label for="content">Blog Post Content</label>
                    <textarea name="blogText" class="form-control" id="blog-post-content">${blogPost.blogText}</textarea>
                </div>
                <div class="form-group">
                    <label for="imagePath">External Image Path</label>
                    <input type="text" class="form-control" id="static-page-title" name="imagePath" placeholder="ex. http://i.imgur.com/abD9Xnp.jpg"
                           value="${blogPost.imagePath}">
                </div>
                <div class="form-group">
                    <label for="categoryString">Categories (Separated by comma)</label>
                    <input type="text" class="form-control" id="blog-post-categories" name="categoryString" placeholder="Seasonal,Event,Recipe" value="${blogPost.categoryString}">
                </div>
                <div class="form-group">
                    <label for="tagString">Tags (Separated by comma)</label>
                    <input type="text" class="form-control" id="blog-post-tags" name="tagString" placeholder="chocolate,cake,frosting" value="${blogPost.tagString}">
                </div>
                <div class="form-group" hidden>
                    <input type="text" name="blogPostId" value="${blogPost.blogPostId}">
                </div>
                <div class="form-group">
                    <input type="submit" value="Submit">
                </div>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
