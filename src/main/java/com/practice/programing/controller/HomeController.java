package com.practice.programing.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.practice.programing.dao.MemberDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/goLogin", method = RequestMethod.GET)
	public String goLogin() {
		return "goLogin";
	}
	@RequestMapping(value = "/goJoin", method = RequestMethod.GET)
	public String goJoin() {
		return "goJoin";
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public RedirectView join(String m_id, String m_pass) {
		String location = "sucJoin";
		try {
			dao.get(m_id);
			location = "failedJoin";
		} catch (Exception e) {
			System.out.println(m_id + "중복 없음");
		}
		System.out.println("m_id : " + m_id + "m_pass : " +  m_pass);
//		dao.insert(m_id, m_pass);
		RedirectView rv = new RedirectView(location);
		return rv;
		// TODO : sucJoin이랑 failedJoin url만들기
		/*
		 *  TODO : 회원가입시 500에러 발생
		 *  dao.insert()를 주석처리 후 405에러 GET이 문제라고 한다
		 */
	}
	@RequestMapping(value = "/sucJoin", method = RequestMethod.POST)
	public @ResponseBody String sucJoin() {
		// Controller에서 alert("성공") 띄우기 
		return "<script>alert(\"성공\");location.href=\"home\"</script>";
	}
}
