package edu.example.springlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.example.springlab.dao.StudentDAO;
import edu.example.springlab.domain.StudentDTO;

@Controller
public class StudentContoller {
	@Autowired
	StudentDAO dao;
	
	@GetMapping("/test1")
	public ModelAndView t1() {
		ModelAndView mav = new ModelAndView();
		List<StudentDTO> list = dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("studentView");
		return mav;
	}
	
	@GetMapping("/test2")
	public ModelAndView t2() {
		ModelAndView mav = new ModelAndView();
		List<StudentDTO> list = dao.listOrderByScoreDesc();
		mav.addObject("list", list);
		mav.setViewName("studentView");
		return mav;
	}
	
	@GetMapping("/test3")
	public ModelAndView t3(int score) {
		ModelAndView mav = new ModelAndView();
		List<StudentDTO> list = dao.listByScoreGreaterEqualThan(score);
		if(list.size() == 0)
			mav.addObject("msg", score + "점보다 높은 성적을 받은 학생은 없습니다!");
		else
			mav.addObject("list", list);
		mav.setViewName("studentView");
		return mav;
	}
	
	@GetMapping("/test4")
	public ModelAndView t4(String keyword) {
		ModelAndView mav = new ModelAndView();
		List<StudentDTO> list = dao.listByContainName(keyword);
		if(list.size() == 0)
			mav.addObject("msg", keyword + "이 포함된 학생은 없어요.");
		else
			mav.addObject("list", list);
		mav.setViewName("studentView");
		return mav;
	}
	
	@GetMapping("/test5")
	public ModelAndView t5(String name) {
		ModelAndView mav =new ModelAndView();
		Integer num = dao.getScore(name);
		if(num == null)
			mav.addObject("msg", name + "이라는 학생은 없어요.");
		else {
			mav.addObject("num", num);
			mav.addObject("name", name);
		}
		mav.setViewName("studentView");
		return mav;
	}
	
	@GetMapping("/test6")
	public ModelAndView t6() {
		ModelAndView mav = new ModelAndView();
		float avg = dao.getScoreAvg();
			mav.addObject("avg", avg);
		mav.setViewName("studentView");
		return mav;
	}
}
