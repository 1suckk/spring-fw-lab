package edu.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
	@RequestMapping("/educontroller")
	public ModelAndView proc(@RequestParam(defaultValue="0")int gavg){ // 전달할 모델이 없으면 return형을 ModelAndView이게 아니라 String으로 변경해도된다.		
		ModelAndView mav = new ModelAndView(); //ModelAndView : 뷰 객체와 모델 객체를 하나의 객체로 담음.
		String view = "";
		if(gavg >= 90) {
			view = "gradeA";
		}
		else if(gavg >= 80 && gavg < 90) {
			view = "gradeB";
		}
		else if(gavg >= 70 && gavg < 80) {
			view = "gradeC";
		}
		else {
			view = "gradeD";
		}
		mav.setViewName(view);
		return mav;
	}
}
