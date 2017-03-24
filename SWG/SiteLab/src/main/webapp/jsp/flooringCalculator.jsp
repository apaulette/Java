<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Site Lab :: Flooring Calculator</title>
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
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/flooringCalculator">Flooring Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/tipCalculator">Tip Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/unitConverter">Unit Converter</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row content">
            <div class="col-sm-1 col-md-2"></div>
            <div class="col-sm-5 col-md-4">
                <div class="sitelab-form">
                <h2>Flooring Calculator</h2>
                <form class="form-horizontal" id="flooringForm" action="runFlooringCalculator" method="POST">
                    <label for="widthFeet">Width</label><br />
                        <input type="number" min="0" name="widthFeet" placeholder="Width(feet)" class="styledInput" required> + 
                        <input type="number" min="0" max="11" name="widthInches" placeholder="Width(inches)" class="styledInput" required><br />
                    <label for="lengthFeet">Length:</label><br />
                        <input type="number" min="0" name="lengthFeet" placeholder="Length(feet)" class="styledInput" required> + 
                        <input type="number" min="0" max="11" name="lengthInches" placeholder="Length(inches)" class="styledInput" required><br />
                    <label for="costPerSqFt">Material Cost/ft<sup>2</sup>:</label><br />
                        <input type="number" min="0" step="0.01" name="costPerSqFt" placeholder="$0.00" class="styledInput" required><br />
                    <button type="submit" class="customButton">Calculate</button>                    
                </form>
                </div>
            </div>
            <div class="col-sm-5 col-md-4">
                <c:if test="${not empty param}">
                <div class="sitelab-form">
                <h2>Results</h2>
                    <div class="inner-box">
                            <div class="divTable">
                                <div class="divTableBody">
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Provided Width x Length:</strong></div>
                                        <div class="divTableCell">${param.widthFeet}'${param.widthInches}" x ${param.lengthFeet}'${param.lengthInches}"</div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Calculated Area:</strong></div>
                                        <div class="divTableCell"><fmt:formatNumber type="number" maxFractionDigits="3" value="${area}" /> ft<sup>2</sup></div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Provided Cost/ft<sup>2</sup>:</strong></div>
                                        <div class="divTableCell"><fmt:formatNumber type="currency" value="${param.costPerSqFt}" /></div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Total Material Cost:</strong></div>
                                        <div class="divTableCell"><fmt:formatNumber type="currency" value="${totalMaterialCost}" /></div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Installation Time:</strong><br />(at 20 ft<sup>2</sup> material installed per hour)</div>
                                        <div class="divTableCell">${installationTime}</div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Billed Increments:</strong><br />(in 15-minute increments)</div>
                                        <div class="divTableCell">${billedIncrements}</div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Total Labor Cost:</strong><br />(at $86/hour)</div>
                                        <div class="divTableCell"><fmt:formatNumber type="currency" value="${totalLaborCost}" /></div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell headerStyle"><strong>GRAND TOTAL:</strong></div>
                                        <div class="divTableCell headerStyle"><fmt:formatNumber type="currency" value="${grandTotal}" /></div>
                                    </div>                                    
                                </div>
                            </div>                        
                    </div>
                </div>
                </c:if>
            </div>
            <div class="col-sm-1 col-md-2"></div>
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
