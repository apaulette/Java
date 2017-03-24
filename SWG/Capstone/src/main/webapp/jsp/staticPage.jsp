<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Baked :: <c:out value="${staticPage.title}"/></title>
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
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){		
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},900);
            });
        });
    </script>
    <!---->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/template/favicon.png">
</head>
<body>
    <sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
    <sec:authorize access="hasRole('ROLE_MODERATOR')" var="isModerator" />
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
                    </div>                    <div class="clearfix"></div>
                    <script>
                        $("span.menu").click(function(){
                        $(".top-menu ul").slideToggle("slow" , function(){
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
                       <div class="content-grid-head">
                            <s:url value="approveStaticPage" var="approveStaticPage_url">
                                <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                            </s:url>
                            <s:url value="unapproveStaticPage" var="unapproveStaticPage_url">
                                <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                            </s:url>
                            <s:url value="editStaticPage" var="editStaticPage_url">
                                <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                            </s:url>                        
                            <s:url value="deleteStaticPage" var="deleteStaticPage_url">
                                <s:param name="staticPageId" value="${staticPage.staticPageId}" />
                            </s:url>
                            <sec:authorize access="${isAdmin}">
                            <h5>
                                <c:choose>    
                                    <c:when test="${staticPage.isApproved == 0}">
                                        <a href="${approveStaticPage_url}" onclick="return confirm('Approve Static Page &quot;${staticPage.title}&quot;?')"><span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></a>&nbsp;&nbsp;|&nbsp;&nbsp; 
                                        <span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>&nbsp;&nbsp;|&nbsp;&nbsp;
                                    </c:when>
                                    <c:otherwise>
                                        <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>&nbsp;&nbsp;|&nbsp;&nbsp; 
                                        <a href="${unapproveStaticPage_url}" onclick="return confirm('Unapprove Static Page &quot;${staticPage.title}&quot;?')"><span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span></a>&nbsp;&nbsp;|&nbsp;&nbsp;
                                    </c:otherwise>
                                </c:choose>                                  
                                <a href="${editStaticPage_url}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>&nbsp;&nbsp;|&nbsp;&nbsp;                                
                                <a href="${deleteStaticPage_url}" onclick="return confirm('Permanently Delete Static Page &quot;${staticPage.title}&quot;?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>                               
                            </h5>
                            </sec:authorize>
                            <div class="clearfix"></div>
                        </div>
                        <div class="content-grid-single">
                            <h3><c:out value="${staticPage.title}"/></h3>
                            <c:if test="${not empty staticPage.imagePath}">
                            <img src="${pageContext.request.contextPath}/images/${staticPage.imagePath}" class="single-pic">
                            </c:if>
                            <c:out value="${staticPage.staticPageText}" escapeXml="false"/>
                            <br clear="all">
                        </div>
                    </div>			 			 
                </div>
                <div class="col-md-4 content-main-right">
                    <div class="search">
                        <h3>SEARCH HERE</h3>
                            <form action="/searchPosts" method="POST">
                                <input type="text" name="searchBlogPosts" id="blog-search-bar">
                                <input type="submit" value="">
                            </form>
                    </div>
                    <div class="categories">
                        <h3>CATEGORIES</h3>
                        <c:forEach items="${CategoryList}" var="Category">
                            <s:url value="/searchCategories" var="searchCategories_url">
                                <s:param name="categoryId" value="${Category.categoryId}"/>
                            </s:url>
                            <li><a href="${searchCategories_url}">${Category.name}</a></li>
                        </c:forEach>
                    </div>
                    <div class="categories">
                        <h3>TAGS</h3>
                        <div id="tagCloud" style="width: 100%; height: 120px;">
                        </div>
                    </div>
                    <div class="archives">
                        <h3>DATE</h3>
                        <div id="yearAccordion">
                        <c:forEach items="${yearMonthsMap}" var="year">
                            <h4 style="cursor:pointer"><c:out value="${year.key}"/></h4>
                            <div>
                            <c:forEach items="${year.value}" var="month">
                                <s:url value="/searchDate" var="searchDate_url">
                                    <s:param name="yearMonthFilter" value="${year.key}::${month}"/>
                                </s:url>
                                <li><a href="${searchDate_url}"><c:out value="${month}"/></a></li>
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
                    <a href="#"><span class="fb"> </span></a>
                    <a href="#"><span class="twt"> </span></a>
                    <a href="#"><span class="in"> </span></a>				 			 
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
        $(document).ready(function() {
        /*
        var defaults = {
        containerID: 'toTop', // fading element id
        containerHoverID: 'toTopHover', // fading element hover id
        scrollSpeed: 1200,
        easingType: 'linear' 
        };
        */
        $().UItoTop({ easingType: 'easeOutQuart' });
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
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/template/banner-rotate2.js"></script>
    <script>
            
        var word_array = [];
        <c:forEach items="${tagList}" var="tag">
            <s:url value="/searchTags" var="searchTags_url">
                <s:param name="tagId" value="${tag.tagId}"/>
            </s:url>

            word_array.push({text: '${tag.name}', weight: ${tag.count}, link: '${searchTags_url}'});
        </c:forEach>

        $(function() {
            $("#tagCloud").jQCloud(word_array);
        });
    </script>
    <a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>