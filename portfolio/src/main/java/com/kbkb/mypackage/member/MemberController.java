package com.kbkb.mypackage.member;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService ms;
	
	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value = "/login")
	public String login(Model model, 
					MemberDTO param_md,
					HttpSession session) {

		MemberDTO db_md 
			= (MemberDTO) sqlsession.selectOne("members.selectlogin", param_md);
		
		if( param_md != null && db_md !=null) {
			if( param_md.getEmail().equals( db_md.getEmail() ) ) {
				session.setAttribute("db_md", db_md);
			}
		}else {
			model.addAttribute("logininfo",
					"<span style='color:red;'>아이디나 비밀번호 확인하세요.</span>");
		}
		
		model.addAttribute("menu", "home");
		List<MemberDTO> al = sqlsession.selectList("members.selectAll");
		model.addAttribute("memberList", al);
		return "/";
	}
	
	@RequestMapping(value = "/register")
	public String join(Model model, HttpSession session) {
		return "/register";
	}
	
	@RequestMapping(value = "/member/joinProc")
	public String joinProc(Model model, HttpSession session,
				MemberDTO mdto	) {
		int temp = sqlsession.insert("members.insertmember",mdto);
		if( temp ==1 ) {
			session.setAttribute("db_md", mdto);
			List<MemberDTO> al = sqlsession.selectList("members.selectAll");
			model.addAttribute("memberList", al);
			return "/";
		}else {
			model.addAttribute("joininfo","피치못할사정에 insert실패했어요..");
			return "/register";
		}
	}
	
	@RequestMapping(value = "/member/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	@RequestMapping(value = "/member")
	public String home(Locale locale, Model model) {
		List<MemberDTO> list = sqlsession.selectList("members.selectpage", new Page(1, 10));
		int pageCnt = sqlsession.selectOne("members.selectcount");
		
		model.addAttribute("memberListPage", list);
		model.addAttribute("memberListCount", pageCnt);
		model.addAttribute("menu", "member");

		return "member/index";
	}

	@RequestMapping(value = "/member/{page}")
	public String home(Locale locale, Model model, 
			@PathVariable(value = "page") int page) {
		
		int pageCount = 10;
		Page pageobj = new Page(1, 10);
		
		if(page ==1) {
			pageobj.setStartrow(1);
			pageobj.setEndrow(10);
		}
		else {
			pageobj.setStartrow( (page-1) * pageCount);
			pageobj.setEndrow( page * pageCount);
		}
		
		List<MemberDTO> list = sqlsession.selectList("members.selectpage", pageobj);
		int pageCnt = sqlsession.selectOne("members.selectcount");

		model.addAttribute("page", page);
		model.addAttribute("memberListPage", list);
		model.addAttribute("memberListCount", pageCnt);
		model.addAttribute("menu", "member");

		return "member/index";
	}

}








