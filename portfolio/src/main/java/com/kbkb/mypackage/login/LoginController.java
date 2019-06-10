package com.kbkb.mypackage.login;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	SqlSession sqlsession;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("�α��� ���������̵�");
		return "login";
	}
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.GET)
	public String loginCheck(Model model) {
		System.out.println("�����ͺ��̽��� �����ؼ� �α��� üũ �� ����");
		//�α��� �����ϸ� ���ǿ��ٰ� �� �����ϰ�  index.jsp �� �̵�
		boolean success = false;
		sqlsession.selectOne("");
		
		if(success) {
			return "index";
		}
		else {
		//�α��� �����ҽÿ��� login.jsp �� �߿�� ���̵� �н����� Ʋ�ȴ� ��� �޽��� �����ֱ�
			model.addAttribute("logininfo","���̵�� �н����尡 Ʋ�ȴ�.");
			return "login";
		}
	}
	
}
