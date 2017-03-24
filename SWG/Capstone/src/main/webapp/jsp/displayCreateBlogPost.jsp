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
        <title>Create New Post</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce-init.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>Create New Post</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Back to Main Site</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/portalHome">Portal Home</a></li>                     
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayCreateBlogPost">Create New Blog Post</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createStaticPage">Create New Static Page</a></li>                    
                    <li role="presentation"><a href="${pageContext.request.contextPath}/pendingApproval">Pending Blog Posts</a></li>                  
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/createNewUser">Create New User</a></li>
                    </sec:authorize> 
                    <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>     
                </ul>    
            </div>
            <form action="createBlogPost" method="POST">
                <div class="form-group">
                    <label for="title">Blog Post Title</label>
                    <input type="text" class="form-control" id="blog-post-title" name="title" placeholder="Title" required>
                </div>
                <div class="form-group">
                    <label for="content">Blog Post Content</label>
                    <textarea name="blogText" class="form-control" id="blog-post-content">Post content</textarea>
                </div>
                <div class="form-group">
                    <label for="title">External Image Path</label>
                    <input type="text" class="form-control" id="static-page-title" name="imagePath" placeholder="ex. http://i.imgur.com/abD9Xnp.jpg">
                </div>
                <div class="form-group">
                    <label for="categories">Categories (Separated by commas)</label>
                    <input type="text" class="form-control" id="blog-post-categories" name="categoryString" placeholder="Seasonal,Event,Recipe">
                </div>
                <div class="form-group">
                    <label for="tags">Tags (Separated by commas)</label>
                    <input type="text" class="form-control" id="blog-post-tags" name="tagString" placeholder="chocolate,cake,frosting">
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
