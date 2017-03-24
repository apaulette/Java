<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Baked :: Home</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/template/styles.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/jqcloud.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Blogname Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!----webfonts---->
        <link href='http://fonts.googleapis.com/css?family=Oswald:100,400,300,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,300italic,400italic,600italic' rel='stylesheet' type='text/css'>
        <!----//webfonts---->
        <script src="${pageContext.request.contextPath}/js/template/jquery.min.js"></script>
        <!--end slider -->
        <!--script-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/template/move-top.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/template/easing.js"></script>
        <!-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/template/image-ar.js"></script> -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jqcloud-1.0.4.min.js"></script>
        <!--/script-->
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 900);
                });
            });
        </script>
        <!---->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/template/favicon.png">
    </head>
    <body>
        <!---strat-banner---->
        <div class="banner" id="banner">				
            <div class="header">  
                <div class="container">
                    <div class="logo">
                        <a href="${pageContext.request.contextPath}/home"> <img src="${pageContext.request.contextPath}/images/template/logo.png" title="soup" /></a>
                    </div>
                    <!---start-top-nav---->
                    <div class="top-menu">
                        <span class="menu"> </span> 
                        <ul>
                        <sec:authorize access="!hasRole('ROLE_MODERATOR')">    
                            <li><a href="${pageContext.request.contextPath}/login">LOGIN</a></li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_MODERATOR')">
                            <li><a href="${pageContext.request.contextPath}/portalHome">PORTAL</a></li>                        
                            <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">LOG OUT</a></li>
                        </sec:authorize>
                            <div class="clearfix"> </div>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                    <script>
                        $("span.menu").click(function () {
                            $(".top-menu ul").slideToggle("slow", function () {
                            });
                        });
                    </script>
                    <!---//End-top-nav---->					
                </div>
            </div>
            <div class="container">
                <div class="banner-head">
                    <h1>&nbsp;</h1>
                    <h2>&nbsp;</h2>
                </div>
                
                <div class="banner-links">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/home">HOME</a></li>
                        <c:if test="${not empty staticPageLinks}">    
                            <c:forEach items="${staticPageLinks}" var="staticPage">
                                <c:if test="${staticPage.isApproved == 1}">
                                    <li><a href="${pageContext.request.contextPath}/staticPage/${staticPage.staticPageId}"><span style="text-transform:uppercase;">${staticPage.title}</span></a></li>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <div class="clearfix"></div>
                    </ul>
                </div>
                
            </div>
        </div>
        <!---//End-banner---->
        <div class="content">
            <div class="container">
                <div class="content-grids">
                    <div class="col-md-8 content-main">
				 <div class="content-grid">
				 </div>
                        
                        <div class="searchResults">
                        <!-- conditional jstl tags for search results -->
                        <c:if test="${not empty searchCriteria}">
                            <h3 style="float:left;">Search keyword: ${searchCriteria}</h3>
                            <h5 style="float:right;"><a href="${pageContext.request.contextPath}/home">Reset Search Results</a></h5>
                            <br clear="all">
                        </c:if>
                        <!-- conditional jstl tags for date results -->    
                        <c:if test="${not empty monthYearCriteria}">
                            <h3 style="float:left;">Posted in ${monthYearCriteria}</h3>
                            <h5 style="float:right;"><a href="${pageContext.request.contextPath}/home">Reset Search Results</a></h5>
                            <br clear="all">
                        </c:if>
                        <!-- conditional jstl tags for category results -->    
                        <c:if test="${not empty categoryIdResult}">
                            <h3 style="float:left;">Category: ${categoryNameResult}</h3>
                            <h5 style="float:right;"><a href="${pageContext.request.contextPath}/home">Reset Search Results</a></h5>
                            <br clear="all">
                        </c:if>
                        <!-- conditional jstl tags for tag results -->    
                        <c:if test="${not empty tagIdResult}">
                            <h3 style="float:left;">Tag: ${tagNameResult}</h3>
                            <h5 style="float:right;"><a href="${pageContext.request.contextPath}/home">Reset Search Results</a></h5>
                            <br clear="all">
                        </c:if>    
                        <c:if test="${(not empty monthYearCriteria) || (not empty searchCriteria) || (not empty categoryIdResult) || (not empty tagIdResult)}">
                            <%-- conditional statement to print appropriate grammar based on size of results --%>
                            <c:choose>
                                <%-- if totalBlogPosts == 1 --%>
                                <c:when test="${totalBlogPostCount == 1}">
                                    <h4>${totalBlogPostCount} Result Found</h4>
                                </c:when>
                                <%-- if totalBlogPosts > 1 --%>
                                <c:otherwise>
                                    <h4>${totalBlogPostCount} Results Found</h4>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                        <c:if test="${empty blogPostList && not empty searchCriteria}"><h4>Search returned no matches</h4></c:if>
                        <c:forEach items="${blogPostList}" var="blogPost">
                            <div class="content-grid-sec">
                                <div class="content-sec-info">
                                    <h3><a href="displaySubmittedBlogPost/${blogPost.blogPostId}">${blogPost.title}</a></h3>
                                    <fmt:parseDate value="${blogPost.date}" var="parsedDate" pattern="yyyy-MM-dd HH:mm:ss.S"/>
                                    <h4><fmt:formatDate value="${parsedDate}" type="date" dateStyle="long"/></h4>
                                    <s:url value="deleteSubmittedBlogPost" var="deleteSubmittedBlogPost_url">
                                        <s:param name="blogPostId" value="${blogPost.blogPostId}" />
                                    </s:url>
                                    <s:url value="/displayEditBlogPost" var="displayEditBlogPost_url">
                                        <s:param name="blogPostId" value="${blogPost.blogPostId}" />
                                    </s:url>                       
                                    <sec:authorize access="hasRole('ROLE_MODERATOR')">
                                    <a href="${displayEditBlogPost_url}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    &nbsp;&nbsp;|&nbsp;&nbsp;<a href="${deleteSubmittedBlogPost_url}" onclick="return confirm('Permanently Delete Static Page &quot;${blogPost.title}&quot;?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                                    </sec:authorize> 
                                    <c:if test="${not empty blogPost.imagePath}">
                                        <img src="${pageContext.request.contextPath}/images/${blogPost.imagePath}" class="entryImage">
                                    </c:if>
                                    <c:set var="blogText" value="${blogPost.blogText}"/>
                                    <c:set var="blogTextLength" value="${fn:length(blogText)}" />
                                    <c:set var="blogTextWithEllipses" value="${fn:substringBefore(blogText, '</p>')}" />
                                    <c:choose>
                                        <c:when test="${blogTextLength < 400}">
                                            <c:out value="${blogTextWithEllipses}" escapeXml="false"/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:out value="${blogPost.blogText}" escapeXml="false"/> ...                                            
                                        </c:otherwise>
                                    </c:choose>
                                    <br clear="all">
                                    <a class="bttn" href="displaySubmittedBlogPost/${blogPost.blogPostId}">MORE</a>
                                </div>
                            </div>
                        </c:forEach>
                        </div>
                        
                        <div class="pages">
                            <ul>
                                <%-- pagination: create indexes --%>
                                <c:forEach begin="1" end="${numberOfPages}" var="i">
                                <s:url value="${endpoint}" var="pageNumber_url">
                                    <s:param name="page" value="${i}"/>
                                    <c:if test="${not empty searchCriteria}">
                                        <s:param name="searchCriteria" value="${searchCriteria}"/>
                                    </c:if>
                                    <c:if test="${not empty categoryIdResult}">
                                        <s:param name="categoryIdPage" value="${categoryIdResult}"/>
                                    </c:if>
                                    <c:if test="${not empty tagIdResult}">
                                        <s:param name="tagIdPage" value="${tagIdResult}"/>
                                    </c:if>
                                    <c:if test="${not empty yearMonthFilterResult}">
                                        <s:param name="yearMonthFilterPage" value="${yearMonthFilterResult}"/>
                                    </c:if>
                                </s:url>
                                <li><a href="${pageNumber_url}">${i}</a></li>
                                </c:forEach>
                                <c:if test="${currentPage != 1}">
                                <s:url value="${endpoint}" var="pageNumber_url">
                                    <s:param name="page" value="${currentPage - 1}"/>
                                    <c:if test="${not empty searchCriteria}">
                                        <s:param name="searchCriteria" value="${searchCriteria}"/>
                                    </c:if>
                                    <c:if test="${not empty categoryIdResult}">
                                        <s:param name="categoryIdPage" value="${categoryIdResult}"/>
                                    </c:if>
                                    <c:if test="${not empty tagIdResult}">
                                        <s:param name="tagIdPage" value="${tagIdResult}"/>
                                    </c:if>
                                    <c:if test="${not empty yearMonthFilterResult}">
                                        <s:param name="yearMonthFilterPage" value="${yearMonthFilterResult}"/>
                                    </c:if>
                                </s:url>
                                <li><a href="${pageNumber_url}">Previous</a></li>
                                </c:if>
                                <c:if test="${not empty blogPostList && currentPage != numberOfPages}">
                                <s:url value="${endpoint}" var="pageNumber_url">
                                    <s:param name="page" value="${currentPage + 1}"/>
                                    <c:if test="${not empty searchCriteria}">
                                        <s:param name="searchCriteria" value="${searchCriteria}"/>
                                    </c:if>
                                    <c:if test="${not empty categoryIdResult}">
                                        <s:param name="categoryIdPage" value="${categoryIdResult}"/>
                                    </c:if>
                                    <c:if test="${not empty tagIdResult}">
                                        <s:param name="tagIdPage" value="${tagIdResult}"/>
                                    </c:if>
                                    <c:if test="${not empty yearMonthFilterResult}">
                                        <s:param name="yearMonthFilterPage" value="${yearMonthFilterResult}"/>
                                    </c:if>
                                </s:url>
                                <li><a href="${pageNumber_url}">Next</a></li>
                                </c:if>
                            </ul>
                        </div>				 
                    </div>
                    <div class="col-md-4 content-main-right">
                        <div class="search">
                            <h3>SEARCH HERE</h3>
                            <form action="searchPosts" method="POST">
                                <input type="text" name="searchBlogPosts" id="blog-search-bar">
                                <input type="submit" value="">
                            </form>
                        </div>
                        <div class="categories">
                            <h3>CATEGORIES</h3>
                            <c:forEach items="${CategoryList}" var="Category">
                                <s:url value="searchCategories" var="searchCategories_url">
                                    <s:param name="categoryId" value="${Category.categoryId}"/>
                                </s:url>
                                <li><a href="${searchCategories_url}">${Category.name}</a></li>
                            </c:forEach>
                        </div>
                        <div class="categories" >
                            <h3>TAGS</h3>
                            <div id="tagCloud" style="width: 100%; height: 120px;">
                            </div>      
                        </div>
                        <div class="archives">
                            <h3>DATE</h3>
                            <div id="yearAccordion">
                            <c:forEach items="${yearMonthsMap}" var="year">
                                <h4 class="archivesYear"><c:out value="${year.key}"/></h4>
                                <div>
                                <c:forEach items="${year.value}" var="month">
                                    <s:url value="searchDate" var="searchDate_url">
                                        <s:param name="yearMonthFilter" value="${year.key}::${month}"/>
                                    </s:url>
                                    <li><a href="${searchDate_url}">- <c:out value="${month}"/></a></li>
                                </c:forEach>
                                </div>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <!--footer-->
        <div class="footer">
            <div class="container">
                <div class="col-md-4 footer-info">
                    <h3>ABOUT THE COOKIEMONSTARS</h3>
                    <p>The CookieMONSTARS are Jared Swihart, Dale Weller, Damani Hamzah, and Amanda Paulette.</p>
                </div>
                <div class="col-md-4 footer-list">
                    <h3>LEARN MORE</h3>
                    <ul>
                        <c:if test="${not empty staticPageLinks}">    
                            <c:forEach items="${staticPageLinks}" var="staticPage">
                                <c:if test="${staticPage.isApproved == 1}">
                                    <li><a href="${pageContext.request.contextPath}/staticPage/${staticPage.staticPageId}">${staticPage.title}</a></li>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </ul>
                </div>
                <div class="col-md-4 footer-media">
                    <h3>FOLLOW US ON....</h3>
                    <div class="social-icons">
                        <a href="http://elfyourself.com?mId=69284166"><span class="fb"> </span></a>
                        <a href="https://twitter.com/sadukie?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"><span class="twt"> </span></a>
                        <a href="https://www.linkedin.com/in/sadukie"><span class="in"> </span></a>				 			 
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!---footer/-->
        <div class="copywrite">
            <div class="container">
                <p>Copyrights &copy; 2015 Blogging All rights reserved | Template by <a href="http://w3layouts.com/">W3layouts</a></p>
            </div>
        </div>
        <!---->
        <script type="text/javascript">
            $(document).ready(function () {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */
                $().UItoTop({easingType: 'easeOutQuart'});
            });
        </script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function() {
                $("#yearAccordion").accordion({
                    header: 'h4',
                    collapsible: true,
                    active: false
                });
            });
        </script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/template/banner-rotate.js"></script>
        <a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

        <script>
            
            var word_array = [];
            <c:forEach items="${tagList}" var="tag">
                <s:url value="searchTags" var="searchTags_url">
                    <s:param name="tagId" value="${tag.tagId}"/>
                </s:url>

                word_array.push({text: '${tag.name}', weight: ${tag.count}, link: '${searchTags_url}'});
            </c:forEach>
            
            $(function() {
                $("#tagCloud").jQCloud(word_array);
            });
        </script>   

    </body>
</html>