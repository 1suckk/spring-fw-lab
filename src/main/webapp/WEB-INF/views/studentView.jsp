<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ !empty avg }">
	<h2>평균 점수는 ${avg}점입니다.</h2>
</c:if>

<c:if test="${ !empty num }">
	<h2>${name} 학생의 점수는 ${num}점입니다.</h2>
</c:if>

<c:if test="${ !empty list }">
	<ul>
		<c:forEach var="vo"  items="${list}">
			<li>${vo}</li>
		</c:forEach>
	</ul>
</c:if>

<c:if test="${ !empty msg }">
	<h2>${msg}</h2>
</c:if>
</body>
</html>