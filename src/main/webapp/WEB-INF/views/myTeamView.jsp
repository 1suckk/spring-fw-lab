<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>우리팀 소개</title>
	<style>
		a {
			text-decoration: none; /* 밑줄 제거 */
		}
	</style>
</head>
<body>
    <h1><a href="/springlab/myTeam1">우리팀 소개</a></h1>
    <button><a href="/springlab/myTeam1?info=teamName">우리 팀명</a></button>
    <button><a href="/springlab/myTeam1?info=teamMember">우리 팀원</a></button>

    <hr/>

    <div id="content">
        <%-- 'info'가 'teamName'일 때만 팀명 정보 출력 --%>
        <c:if test="${info eq 'teamName'}">
            <h2>우리 팀의 팀명은 ${myteam.teamName}입니다.</h2>
        </c:if>

        <%-- 'info'가 'teamMember'일 때만 팀원 정보 출력 --%>
        <c:if test="${info eq 'teamMember'}">
            <h2>${myteam.teamName}의 팀원들을 소개합니다.</h2>
            <ul>
                <c:forEach var="member" items="${myteam.teamMember}">
                    <li>${member.name} : 별명은 ${member.nicName}이고 좋아하는 음식은 ${member.food}입니다.</li>
                </c:forEach>
            </ul>
        </c:if>
    </div>
</body>
</html>