package com.kbkb.mypackage.tables;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kbkb.mypackage.tables.TablesDTO;;

@Controller
public class TablesController {
	
	private static final Logger logger = LoggerFactory.getLogger(TablesController.class);
	
	@Autowired
	TablesService ms;
	
	@Autowired
	SqlSession sqlSession; 
	
//	//로그인
//	@RequestMapping(value = "/tables/login")
//	public String login(Model model,
//			TablesDTO param_md,
//			HttpSession session) {
//		
//		TablesDTO db_md
//			=(TablesDTO) sqlSession.selectOne("Tables.selectlogin",param_md);
//		
//		if( param_md !=null&& db_md !=null) {
//			if(param_md.getEmail().equals(db_md.getEmail() ) ) {
//				session.setAttribute("db_md", db_md);
//			}
//		}else {
//			model.addAttribute("logininfo",
//					"<span style='color:red;'>아이디나 비밀번호 확인하세요.</span>");
//		}
//			
//		model.addAttribute("menu", "tables");
//		List<TablesDTO> al = sqlSession.selectList("Tables.selectAll");
//		model.addAttribute("tablesList", al);
//		return "/";
//	}
	
	@RequestMapping(value = "/register/join")
	public String join(Model model,HttpSession session) {
		System.out.println("일로오나");
//		model.addAttribute("aaaa", "aaaa values");
//		model.addAttribute("logininfo", "login info 할까요?");
		return "login";
	}
	
	@RequestMapping(value = "/register/joinProc" )
	public String register(Model model, HttpSession session,
			TablesDTO mdto) {
		System.out.println(mdto);
		int temp = sqlSession.insert("Tables.insertables",mdto);
		if(temp ==1) {
			System.out.println("insert 성공");
			session.setAttribute("db_md", mdto);
			List<TablesDTO> al = sqlSession.selectList("Tables.selectAll");
			model.addAttribute("tablesList", al);
			return "tables";
		}else {
			System.out.println("insert 실패");
			model.addAttribute("joininfo","피치못할사정에 insert실패했어요..");
			return "login";
		}	
	}
	
	
	
	@RequestMapping(value = "/tables", method = {RequestMethod.GET,RequestMethod.POST})
	public String home(Model model) {
		List<TablesDTO> list = sqlSession.selectList("Tables.selectAll");
		model.addAttribute("list",list);
		return "tables";
	}
	
}
