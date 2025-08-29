package edu.example.springlab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.example.springlab.domain.TeamDTO;
import edu.example.springlab.domain.TeamMemberVO;

@Controller
@RequestMapping("/myTeam1")
public class MyTeamController1 {

	 @GetMapping
	    public String myteam(@RequestParam(required = false) String info, Model model) {
	        // JSP에서 어떤 버튼이 눌렸는지 판단할 수 있도록 info 파라미터를 모델에 추가합니다.
	        model.addAttribute("info", info);

	        TeamDTO myTeam = new TeamDTO();
	        myTeam.setTeamName("얼리버드");

	        if ("teamMember".equals(info)) {
	            List<TeamMemberVO> teamMembers = new ArrayList<>();
	            teamMembers.add(new TeamMemberVO("박지현", "인간이 아닌 무언가", "빵"));
	            teamMembers.add(new TeamMemberVO("박지혜", "졔", "불닭"));
	            teamMembers.add(new TeamMemberVO("채원석", "원", "짜장면"));
	            myTeam.setTeamMember(teamMembers);
	        }

	        // 'info' 파라미터가 있을 때만 'myteam' 객체를 모델에 추가합니다.
	        if (info != null) {
	            model.addAttribute("myteam", myTeam);
	        }
	        
	        return "myTeamView";
	    }
}