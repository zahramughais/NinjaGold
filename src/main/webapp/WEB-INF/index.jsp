<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Ninja Gold Game</title>
</head>
<body>
    <div id="warpper">
        <p>Your Gold: <span><c:out value="${gold}"/></span></p>
        <div id="forms_div">
            <form action="/gold/process_money" method="post">
                <p>Farm</p>
                <p>(earns 10-20 gold)</p>
                <input type="hidden" name="location" value="farm">
                <button type="submit">Find Gold!</button>
            </form>
            <form action="/gold/process_money" method="post">
                <p>Cave</p>
                <p>(earns 5-10 gold)</p>
                <input type="hidden" name="location" value="cave">
                <button type="submit">Find Gold!</button>
            </form>
            <form action="/gold/process_money" method="post">
                <p>House</p>
                <p>(earns 5-2 gold)</p>
                <input type="hidden" name="location" value="house">
                <button type="submit">Find Gold!</button>
            </form>
            <form action="/gold/process_money" method="post">
                <p>Casino!</p>
                <p>(earns/takes 0-50 gold)</p>
                <input type="hidden" name="location" value="casino">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <p>Activities:</p>
        <div id="display_div">
        <c:forEach var="a" items="${activites}">  
        	<c:choose>
        		<c:when test="${a.contains('earned')}">        		
            	<p class="green"><c:out value="${a}"/></p>
        		</c:when>
        		<c:otherwise>        		
            	<p class="red"><c:out value="${a}"/></p>
        		</c:otherwise>        	
        	</c:choose>   
        </c:forEach>
        </div>
    </div>
</body>
</html>