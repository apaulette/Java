<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Site Lab :: Interest Calculator</title>
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
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/interestCalculator">Interest Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/flooringCalculator">Flooring Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/tipCalculator">Tip Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/unitConverter">Unit Converter</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row content">
            <div class="col-md-2"></div>
            <div class="col-md-4">
                <div class="sitelab-form">
                    <h2>Interest Calculator</h2>
                    <form class="form-horizontal" id="interestForm" action="runInterestCalculator" method="POST">
                        <label for="investmentBalance">Initial Investment:</label><br />
                        <input type="number" min="0" max="1000000" name="initialInvestment" placeholder="$0" class="styledInput" required><br />
                        <label for="interestRate">Interest Rate:</label><br />
                        <input type="number" min="0" max="20" step="0.01" name="interestRate" placeholder="0%" class="styledInput" required><br />
                        <label for="calendarStartYear">Start Year:</label><br />
                        <input type="number" min="1900" name="calendarStartYear" placeholder="2016" class="styledInput" required><br />
                        <label for="yearDuration">Number of Years to Calculate:</label><br />
                        <input type="number" min="1" max="50" name="yearDuration" placeholder="25" class="styledInput" required><br />
                        <label for="compoundFrequency">Compounding Frequency</label><br />
                        <select name="compoundFrequency" class="styledInput">
                            <option value="annually" selected="selected">Annually</option>
                            <option value="semiannually">Semiannually</option>
                            <option value="quarterly">Quarterly</option>
                            <option value="monthly">Monthly</option>
                            <option value="daily">Daily</option>
                        </select><br />
                        <button type="submit" class="customButton">Calculate Interest</button>
                    </form>
                </div>
            </div>
            <div class="col-md-4">
                <c:if test="${not empty calcResults}">
                    <div class="sitelab-form">
                        <h2>Results</h2>
                        <div class="inner-box">
                            <div class="divTable">
                                <div class="divTableBody">
                                    
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Initial&nbsp;Investment:</strong></div>
                                        <div class="divTableCell"><fmt:formatNumber type="currency" maxFractionDigits="0" value="${param.initialInvestment}" /></div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Interest Rate:</strong></div>
                                        <div class="divTableCell">${param.interestRate}%, compounded ${param.compoundFrequency}</div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Starting in Year:</strong></div>
                                        <div class="divTableCell">${param.calendarStartYear}</div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Number&nbsp;of&nbsp;Years:</strong></div>
                                        <div class="divTableCell">${param.yearDuration}</div>
                                    </div>
                                </div>
                            </div>
                            <c:forEach var="calculation" items="${calcResults}">        
                            <div class="divTable marginTop40">
                                <div class="divTableBody">
                                    <div class="divTableRow">
                                        <div class="divTableCell headerStyle"><strong><c:out value="${calculation.calendarYear}"/></strong> (Year <c:out value="${calculation.termYearNumber}"/> of ${param.yearDuration})
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="divTable">
                                <div class="divTableBody">
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Year Beginning Balance:</strong></div>
                                        <div class="divTableCell"><fmt:formatNumber type="currency" maxFractionDigits="2"><c:out value="${calculation.yearBeginningBalance}" /></fmt:formatNumber></div>
                                    </div>
                                    <div class="divTableRow">
                                        <div class="divTableCell"><strong>Year Interest Earned:</strong></div>
                                        <div class="divTableCell"><fmt:formatNumber type="currency" maxFractionDigits="2"><c:out value="${calculation.yearInterestEarned}" /></fmt:formatNumber></div>
                                    </div>
                                        <div class="divTableRow">
                                            <div class="divTableCell"><strong>Year Ending Balance:</strong></div>
                                            <div class="divTableCell"><fmt:formatNumber type="currency" maxFractionDigits="2"><c:out value="${calculation.yearEndingBalance}" /></fmt:formatNumber></div>
                                    </div>
                                </div>
                            </div>                    
                            </c:forEach>
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
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${pageContext.request.contextPath}/js/custom/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
