<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Site Lab :: Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="${pageContext.request.contextPath}/css/custom/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/custom/styles.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row clearfix" id="sitelabHeader">
                <div class="col-xs-12"><div id="pic"><img src="img/logo_swg.png" class="img-responsive"></div>
                    <div id="title">Software Craftsmanship Guild Java Cohort<br>
                    <span class="subhead">JSP Site Lab</span></div>
                </div>
            </div>
        </div>
        <div id="custom-bootstrap-menu" class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse navbar-menubuilder">
                    <ul class="nav navbar-nav navbar-left">
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home"><span class="glyphicon glyphicon-home"></span><span class="sr-only"></span></a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/luckySevens">Lucky Sevens</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/factorizer">Factorizer</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/interestCalculator">Interest Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/flooringCalculator">Flooring Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/tipCalculator">Tip Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/unitConverter">Unit Converter</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row content">
                <div class="col-xs-2 col-sm-3 col-md-1"></div>
                <div class="col-xs-8 col-sm-6 col-md-10">
                    <div class="row">
                        <div class="col-xs-6 col-sm-4 col-md-2 sitelab-home"><a href="${pageContext.request.contextPath}/luckySevens"><img src="${pageContext.request.contextPath}/img/sitelab_luckySevens.jpg" class="img-responsive" border="0"></a><p>Lucky Sevens</p></div>
                        <div class="col-xs-6 col-sm-4 col-md-2 sitelab-home"><a href="${pageContext.request.contextPath}/factorizer"><img src="${pageContext.request.contextPath}/img/sitelab_factorizer.jpg" class="img-responsive" border="0"></a><p>Factorizer</p></div>
                        <div class="col-xs-6 col-sm-4 col-md-2 sitelab-home"><a href="${pageContext.request.contextPath}/interestCalculator"><img src="${pageContext.request.contextPath}/img/sitelab_interestCalculator.jpg" class="img-responsive" border="0"></a><p>Interest Calculator</p></div>
                        <div class="col-xs-6 col-sm-4 col-md-2 sitelab-home"><a href="${pageContext.request.contextPath}/flooringCalculator"><img src="${pageContext.request.contextPath}/img/sitelab_flooringCalculator.jpg" class="img-responsive" border="0"></a><p>Flooring Calculator</p></div>
                        <div class="col-xs-6 col-sm-4 col-md-2 sitelab-home"><a href="${pageContext.request.contextPath}/tipCalculator"><img src="${pageContext.request.contextPath}/img/sitelab_tipCalculator.jpg" class="img-responsive" border="0"></a><p>Tip Calculator</p></div>
                        <div class="col-xs-6 col-sm-4 col-md-2 sitelab-home"><a href="${pageContext.request.contextPath}/unitConverter"><img src="${pageContext.request.contextPath}/img/sitelab_unitConverter.jpg" class="img-responsive" border="0"></a><p>Unit Converter</p></div>
                    </div>
                </div>
                <div class="col-xs-2 col-sm-3 col-md-1"></div>
            </div>
        </div>
        <footer class="footer">
            <div class="container"><p>Created by Amanda Paulette | 2016<br>
                    Powered by Java and Bootstrap</p></div>
        </footer>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.request.contextPath}/js/custom/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
