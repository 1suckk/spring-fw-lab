package edu.example.springlab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.example.springlab.domain.TeamDTO;
import edu.example.springlab.domain.TeamMemberVO;

@Controller
public class MyTeamController2 {

    // 뷰(JSP)를 통해서 응답하는 메서드
    // 매핑명: /myTeamMain
    @GetMapping("/myTeamMain")
    public String myTeamMain() {
        return "myTeamAjaxView";
    }

    // 컨트롤러가 직접 응답하는 메서드 (@ResponseBody 사용)
    // 매핑명: /myTeamData
    @GetMapping("/myTeamData")
    @ResponseBody
    public TeamDTO myTeamData() {
        TeamDTO myTeam = new TeamDTO();
        myTeam.setTeamName("얼리버드");

        List<TeamMemberVO> teamMembers = new ArrayList<>();
        // PDF에 명시된 팀원 정보를 추가합니다. 
        teamMembers.add(new TeamMemberVO("박지현", "인간이 아닌 무언가", "빵"));
        teamMembers.add(new TeamMemberVO("박지혜", "졔", "불닭"));
        teamMembers.add(new TeamMemberVO("채원석", "원", "짜장면"));
        myTeam.setTeamMember(teamMembers);

        return myTeam; //DTO를 리턴한다
    }
}