<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pending Approval</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!--  <style>
        #sortable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
        #sortable li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
        #sortable li span { position: absolute; margin-left: -1.3em; }
        </style> -->
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dragStaticOrder.js"></script>
    </head>
    <body>
        <sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
        <sec:authorize access="hasRole('ROLE_MODERATOR')" var="isModerator" />
        <div class="container">
            <h1>Pending Approval</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation"><a href="${pageContext.request.contextPath}/home">Back to Main Site</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/portalHome">Portal Home</a></li>                        
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayCreateBlogPost">Create New Blog Post</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/createStaticPage">Create New Static Page</a></li>   
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/pendingApproval">Pending Blog Posts</a></li> 
                        <sec:authorize access="${isAdmin}">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/createNewUser">Create New User</a></li>
                        </sec:authorize>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>
                </ul>    
            </div>
            <h2>Blog Posts</h2>
            <table class="table" id="unapprovedBlogPostTable">
                <thead>
                    <tr>
                        <th width="50%">Blog Posts &mdash; Pending Approval</th>
                        <th width="10%">Date</th>
                        <th width="10%">View</th>
                        <th width="10%">Approve</th>
                        <th width="10%">Edit</th>
                        <th width="10%">Delete</th>
                    </tr>
                </thead>
                    <tbody> 
                    <c:forEach items="${blogPostLinks}" var="blogPost">
                    <c:if test="${blogPost.isApproved == 0}">
                        <s:url value="displayEditBlogPost" var="displayEditBlogPost_url">
                            <s:param name="blogPostId" value="${blogPost.blogPostId}" />
                        </s:url>        
                        <sec:authorize access="${isAdmin}">
                            <s:url value="approveBlogPost" var="approveBlogPost_url">
                                <s:param name="blogPostId" value="${blogPost.blogPostId}" />
                            </s:url>
                            <s:url value="deleteSubmittedBlogPost" var="deleteSubmittedBlogPost_url">
                                <s:param name="blogPostId" value="${blogPost.blogPostId}" />
                            </s:url>
                        </sec:authorize>
                        <fmt:parseDate value="${blogPost.date}" var="parsedDate" pattern="yyyy-MM-dd HH:mm:ss.S"/>
                        <tr class="ui-state-default">
                            <td><a href="${pageContext.request.contextPath}/displaySubmittedBlogPost/${blogPost.blogPostId}">${blogPost.title}</a></td>
                            <td><fmt:formatDate value="${parsedDate}" type="date" dateStyle="short"/></td>
                            <td><a href="${pageContext.request.contextPath}/displaySubmittedBlogPost/${blogPost.blogPostId}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a></td>
                            <td><c:choose>
                                    <c:when test="${isAdmin}"><a href="${approveBlogPost_url}" onclick="return confirm('Approve Static Page &quot;${blogPost.title}&quot;?')"><span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></a></c:when>
                                    <c:otherwise><span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></c:otherwise>
                                </c:choose></td>
                            <td><a href="${displayEditBlogPost_url}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                            <td><c:choose>
                                    <c:when test="${isAdmin}"><a href="${deleteSubmittedBlogPost_url}" onclick="return confirm('Permanently Delete Static Page &quot;${blogPost.title}&quot;?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></c:when>
                                    <c:otherwise><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></c:otherwise>
                                </c:choose></td>
                        </tr>
                    </c:if>
                    </c:forEach>           
                </tbody>
            </table>
            <table class="table" id="approvedBlogPostsTable">
                <thead>
                    <tr>
                        <th width="50%">Blog Posts &mdash; Approved</th>
                        <th width="10%">Date</th>
                        <th width="10%">View</th>
                        <th width="10%">Unapprove</th>
                        <th width="10%">Edit</th>
                        <th width="10%">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${blogPostLinks}" var="blogPost">
                    <c:if test="${blogPost.isApproved == 1}">
                        <s:url value="displayEditBlogPost" var="displayEditBlogPost_url">
                            <s:param name="blogPostId" value="${blogPost.blogPostId}" />
                        </s:url>
                        <sec:authorize access="${isAdmin}">
                            <s:url value="unapproveBlogPost" var="unapproveBlogPost_url">
                                <s:param name="blogPostId" value="${blogPost.blogPostId}" />
                            </s:url>
                            <s:url value="deleteSubmittedBlogPost" var="deleteSubmittedBlogPost_url">
                                <s:param name="blogPostId" value="${blogPost.blogPostId}" />
                            </s:url>
                        </sec:authorize>
                        <fmt:parseDate value="${blogPost.date}" var="parsedDate" pattern="yyyy-MM-dd HH:mm:ss.S"/>
                        <tr class="ui-state-default">
                            <td><a href="${pageContext.request.contextPath}/displaySubmittedBlogPost/${blogPost.blogPostId}">${blogPost.title}</a></td>
                            <td><fmt:formatDate value="${parsedDate}" type="date" dateStyle="short"/></td>
                            <td><a href="${pageContext.request.contextPath}/displaySubmittedBlogPost/${blogPost.blogPostId}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a></td>
                            <td><c:choose>
                                    <c:when test="${isAdmin}"><a href="${unapproveBlogPost_url}" onclick="return confirm('Unapprove Static Page &quot;${blogPost.title}&quot;?')"><span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span></a></c:when>
                                    <c:otherwise><span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span></c:otherwise>
                                </c:choose></td>
                            <td><a href="${displayEditBlogPost_url}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                            <td><c:choose>
                                    <c:when test="${isAdmin}"><a href="${deleteSubmittedBlogPost_url}" onclick="return confirm('Permanently Delete Static Page &quot;${blogPost.title}&quot;?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></c:when>
                                    <c:otherwise><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></c:otherwise>
                                </c:choose></td>
                        </tr>
                    </c:if>
                    </c:forEach>           
                </tbody>
            </table>
            
            <h2>Static Pages</h2>
            <table class="table" id="pendingStaticPageTable">
                <thead>
                    <tr>
                        <th width="50%">Static Page &mdash; Pending Approval</th>
                        <th width="10%">Display Order</th>
                        <th width="10%">View</th>
                        <th width="10%">Approve</th>
                        <th width="10%">Edit</th>
                        <th width="10%">Delete</th>
                    </tr>
                </thead>
                <tbody> 
                    <c:forEach items="${staticPageLinks}" var="staticPage">
                    <c:if test="${staticPage.isApproved == 0}">
                        <s:url value="editStaticPage" var="editStaticPage_url">
                            <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                        </s:url>
                        <sec:authorize access="${isAdmin}">
                            <s:url value="approveStaticPage" var="approveStaticPage_url">
                                <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                            </s:url>
                            <s:url value="deleteStaticPage" var="deleteStaticPage_url">
                                <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                            </s:url>
                        </sec:authorize>
                        <tr class="ui-state-default">
                            <td><a href="${pageContext.request.contextPath}/staticPage/${staticPage.staticPageId}">${staticPage.title}</a></td>
                            <td>${staticPage.displayOrder}</td>
                            <td><a href="${pageContext.request.contextPath}/staticPage/${staticPage.staticPageId}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a></td>
                            <td><c:choose>
                                    <c:when test="${isAdmin}"><a href="${approveStaticPage_url}" onclick="return confirm('Approve Static Page &quot;${staticPage.title}&quot;?')"><span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></a></c:when>
                                    <c:otherwise><span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></c:otherwise>
                                </c:choose></td>
                            <td><a href="${editStaticPage_url}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                            <td><c:choose>
                                    <c:when test="${isAdmin}"><a href="${deleteStaticPage_url}" onclick="return confirm('Permanently Delete Static Page &quot;${staticPage.title}&quot;?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></c:when>
                                    <c:otherwise><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></c:otherwise>
                                </c:choose></td>
                        </tr>
                    </c:if>
                    </c:forEach>           
                </tbody>
            </table>
            
            <table class="table" id="approvedStaticPageTable">
                <thead>
                    <tr>
                        <th width="50%">Static Page &mdash; Approved</th>
                        <th width="10%">Display Order</th>
                        <th width="10%">View</th>
                        <th width="10%">Unapprove</th>
                        <th width="10%">Edit</th>
                        <th width="10%">Delete</th>
                    </tr>
                </thead>
                <tbody id="sortable">
                    <c:forEach items="${staticPageLinks}" var="staticPage">
                    <c:if test="${staticPage.isApproved == 1}">
                        <s:url value="editStaticPage" var="editStaticPage_url">
                            <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                        </s:url>
                        <sec:authorize access="${isAdmin}">
                            <s:url value="unapproveStaticPage" var="unapproveStaticPage_url">
                                <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                            </s:url>
                            <s:url value="deleteStaticPage" var="deleteStaticPage_url">
                                <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                            </s:url>
                        </sec:authorize>
                        <jsp:element name="tr">
                            <jsp:attribute name="class">ui-state-default</jsp:attribute>
                            <jsp:attribute name="id">${staticPage.staticPageId}</jsp:attribute>
                        </jsp:element>
                            <td><a href="${pageContext.request.contextPath}/staticPage/${staticPage.staticPageId}">${staticPage.title}</a></td>
                            <td>${staticPage.displayOrder}</td>
                            <td><a href="${pageContext.request.contextPath}/staticPage/${staticPage.staticPageId}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a></td>
                            <td><c:choose>
                                    <c:when test="${isAdmin}"><a href="${unapproveStaticPage_url}" onclick="return confirm('Unapprove Static Page &quot;${staticPage.title}&quot;?')"><span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span></a></c:when>
                                    <c:otherwise><span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span></c:otherwise>
                                </c:choose></td>
                            <td><a href="${editStaticPage_url}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                            <td><c:choose>
                                    <c:when test="${isAdmin}"><a href="${deleteStaticPage_url}" onclick="return confirm('Permanently Delete Static Page &quot;${staticPage.title}&quot;?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></c:when>
                                    <c:otherwise><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></c:otherwise>
                                </c:choose></td>
                        </tr>
                    </c:if>
                    </c:forEach>           
                </tbody>
            </table>
            
        </div>
        <!-- Placed at the end of the document so the pages load faster -->

    </body>
</html>
