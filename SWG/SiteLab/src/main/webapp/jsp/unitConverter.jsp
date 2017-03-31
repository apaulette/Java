<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Site Lab :: Unit Converter</title>
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
        <div class="container-fixed">
            <div class="row clearfix" id="sitelabHeader">
                <div class="col-xs-12"><div id="pic"><img src="img/logo_swg.png" class="img-responsive"></div><div id="title">Software Craftsmanship Guild Java Cohort<br>
                        <span class="subhead">JSP Site Lab</span></div></div>
            </div>
            <div id="custom-bootstrap-menu" class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse navbar-menubuilder">
                    <ul class="nav navbar-nav navbar-left">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/home"><span class="glyphicon glyphicon-home"></span><span class="sr-only"></span></a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/luckySevens">Lucky Sevens</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/factorizer">Factorizer</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/interestCalculator">Interest Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/flooringCalculator">Flooring Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/tipCalculator">Tip Calculator</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/unitConverter">Unit Converter</a></li>
                    </ul>
                </div>
            </div>
        <div class="row content">
            <div class="col-md-2"></div>
            <div class="col-md-4">
                <div class="sitelab-form">
                    <h2>Unit Converter</h2>
                    <form class="form-horizontal" action="runUnitConverter" method="post">
                        <label for="conversionType">Conversion Type:</label><br />
                        <select class="styledInput" id="conversionType" name="conversionType" onchange="populateNewSelects(this.value)">
                            <option value="Area" selected="selected">Area</option>
                            <option value="Length">Length</option>
                            <option value="Mass">Mass</option>
                            <option value="Temperature">Temperature</option>
                            <option value="Volume">Volume</option>
                        </select><br />
                        <label for="unitFrom">Convert From:</label><br />
                        <select id="unitFrom" name="unitFrom" class="styledInput">
                            <option value="Square Meter">Square Meter</option>
                            <option value="Hectare">Hectare</option>
                            <option value="Square Inch">Square Inch</option>
                            <option value="Square Foot">Square Foot</option>
                            <option value="Square Mile">Square Mile</option>
                            <option value="Acre">Acre</option>
                        </select><br />
                        <label for="unitTo">Convert To:</label><br />
                        <select id="unitTo" name="unitTo" class="styledInput">
                            <option value="Square Meter">Square Meter</option>
                            <option value="Hectare">Hectare</option>
                            <option value="Square Inch">Square Inch</option>
                            <option value="Square Foot">Square Foot</option>
                            <option value="Square Mile">Square Mile</option>
                            <option value="Acre">Acre</option>
                        </select><br />
                        <label for="numberInput">Quantity to Convert:</label><br />
                        <input type="number" min="0" step="0.001" id="numberInput" name="numberInput" placeholder="0.000" class="styledInput" required><br />                                   
                        <button type="submit" id="submitButton" name="submitButton" class="customButton">Convert</button>
                    </form>
                </div>
            </div>
            <div class="col-md-4">
                <c:if test="${not empty conversion}">
                    <div class="sitelab-form">
                        <h2>Results</h2>
                        <div class="inner-box">
                            <div class="divTable">
                                <div class="divTableBody">
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Requested Conversion Source:</strong></div>
                                        <div class="divTableCell">${param.numberInput} ${conversion.unitFrom}</div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell headerStyle"><strong>Is Equal To:</strong></div>
                                        <div class="divTableCell headerStyle"><fmt:formatNumber type="number" maxFractionDigits="3" value="${conversion.convertedNumber}" /> ${conversion.unitTo}</div>
                                    </div>
                                </div>
                            </div>                            
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="col-md-2"></div>
        </div>
        <footer class="footer">
            <div class="container"><p>Created by Amanda Paulette | 2016<br>
                    Powered by Java and Bootstrap</p></div>
        </footer>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/unitConverterSelector.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.request.contextPath}/js/custom/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
