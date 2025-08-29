package edu.example.springlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
	@RequestMapping("/calc")
	public ModelAndView proc(@RequestParam int a,
								@RequestParam int b, @RequestParam String calc)
	{
		ModelAndView mav = new ModelAndView();
		int result = 0;
		boolean errFlag = false;
		String view = "";
		String msg = "";
		
		switch (calc) {
		case "+":
			result = a + b;
			view = "calcResult";
			break;
		case "-":
			result = a - b;
			view = "calcResult";
			break;
		case "*":
			result = a * b;
			view = "calcResult";
			break;
		case "/":
			if (b == 0) {
				errFlag = true;
				msg = "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!";
				view = "errorResult";
			} else {
				result = a / b;
				view = "calcResult";
			}
			break;
		}
	
	if(errFlag)
		mav.addObject("msg", msg);
	else
		mav.addObject("msg", result); 	
		
	mav.setViewName(view);
	return mav;

	}
}