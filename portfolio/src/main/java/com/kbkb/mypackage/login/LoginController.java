package com.kbkb.mypackage.login;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.management.AttributeValueExp;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kbkb.mypackage.tables.TablesDTO;

@Controller
public class LoginController {
	
	@Autowired
	SqlSession sqlsession;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("로그인 페이지로이동");
		return "login";
	}
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.GET)
	public String loginCheck(Model model,
								@RequestParam(required = false) String email,
								@RequestParam(required = false) String pw,
								HttpSession session) {
		System.out.println("데이터베이스에 접속해서 로그인 체크 할 예정");
		//로그인 성공하면 세션에다가 값 저장하고  index.jsp 로 이동
		boolean success = false;
		System.out.println("email "+email);
		System.out.println("pw"+pw);
		
		TablesDTO dto = new TablesDTO();
		dto.setEmail(email);
		dto.setPw(pw);
		
		dto = sqlsession.selectOne("Tables.selectlogin",dto);
		System.out.println("dto = "+dto);
		
		
		if(dto !=null) {
			if(dto.getEmail().equals(dto.getEmail())) {
				session.setAttribute("dto", dto);
			}
			return "index";
		}
		else {
		//로그인 실패할시에는 login.jsp 를 뜨우고 아이디 패스워드 틀렸다 라는 메시지 보여주기
			model.addAttribute("logininfo","아이디와 패스워드가 틀렸다.");
			return "login";
		}
		
		
	}
	
}
