<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우리팀 소개</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700
	&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<style>
body * {
	font-family: 'Jua';
}

a {
	text-decoration: none; /* 밑줄 제거 */
}
</style>
</head>
<body>
    <h1><a href="/springlab/myTeamMain">우리팀 소개</a></h1>
    <button id="teamNameBtn">우리 팀명</button>
    <button id="teamMemberBtn">우리 팀원</button>

    <hr/>

    <div id="content">
        </div>

    <script>
        $(document).ready(function() {
            // '우리 팀명' 버튼 클릭 이벤트
            $('#teamNameBtn').on('click', function() {
                $.ajax({
                    url: '/springlab/myTeamData',
                    type: 'GET',
                    success: function(response) {
                        $('#content').empty();
                        let teamNameHtml = '<h2>우리 팀의 팀명은 ' + response.teamName + '입니다.</h2>';
                        $('#content').append(teamNameHtml);
                    },
                    error: function(xhr, status, error) {
                        console.error("팀명 정보를 가져오는 데 실패했습니다.", error);
                    }
                });
            });

            // '우리 팀원' 버튼 클릭 이벤트
            $('#teamMemberBtn').on('click', function() {
                $.ajax({
                    url: '/springlab/myTeamData',
                    type: 'GET',
                    success: function(response) {
                        $('#content').empty(); //비워야 함
                        let membersHtml = '<h2>' + response.teamName + '팀의 팀원들을 소개합니다.</h2>';
                        membersHtml += '<ul>';
                        $.each(response.teamMember, function(index, member) {
                            membersHtml += '<li>' + member.name + ' : 별명은 ' + member.nicName + '이고 좋아하는 음식은 ' + member.food + '입니다.</li>';
                        });
                        membersHtml += '</ul>';
                        $('#content').append(membersHtml);
                    },
                    error: function(xhr, status, error) {
                        console.error("팀원 정보를 가져오는 데 실패했습니다.", error);
                    }
                });
            });
        });
    </script>
</body>
</html>