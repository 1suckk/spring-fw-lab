package edu.example.springlab.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class StudyPathController {
	@RequestMapping(value="/study/{num}/{stack}", produces = "text/html; charset=utf-8")
	public RedirectView getAllStack(@PathVariable("num") int num,
					@PathVariable("stack") String stack)
	{
		String url = "";
		if(num == 1 && stack.equals("springfw"))
			url = "https://spring.io/projects/spring-framework";
		else if (num == 2 && stack.equals("security")){
            url = "https://spring.io/projects/spring-security";
        } else if (num == 3 && stack.equals("ai")) {
            url = "https://spring.io/projects/spring-ai";
        } else if (num == 4 && stack.equals("mybatis")) {
            url = "https://mybatis.org/mybatis-3";
        }
        RedirectView redirectView =  new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
        // return "redirect:"+url꼴로 써주면 객체 생성하지 않아도 됨
        // redirect시 redirect: 만 붙여주면 나머지는 스프링이 알아서 함
        // 다른 웹 사이트이므로 uri가 아니라 url를 기재해야 함
	}
}
