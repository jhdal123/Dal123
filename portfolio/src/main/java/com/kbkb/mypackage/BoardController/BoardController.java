package com.kbkb.mypackage.BoardController;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kbkb.mypackage.domain.BoardVO;
import com.kbkb.mypackage.domain.Criteria;
import com.kbkb.mypackage.domain.PageMaker;
import com.kbkb.mypackage.domain.SearchCriteria;
import com.kbkb.mypackage.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService service;

	// �� �ۼ� get
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception {
		logger.info("get write");
	}

	// �� �ۼ� post
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception {
		logger.info("post write");

		service.write(vo);

		return "redirect:/";
	}

	// �� ���
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("get list");

		List<BoardVO> list = service.list();

		model.addAttribute("list", list);
	}

	// �� ��ȸ
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void getRead(@RequestParam("idx") int idx, 
						@ModelAttribute("scri") SearchCriteria scri,  Model model) throws Exception {
		logger.info("get read");

		System.out.println(idx);

		BoardVO vo = service.read(idx);

		System.out.println(vo);

		model.addAttribute("read", vo);
		model.addAttribute("scri",scri);

	}

	// �� �� ��
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("idx") int idx, Model model) throws Exception {
		logger.info("get modify");

		BoardVO vo = service.read(idx);

		model.addAttribute("modify", vo);

	}

	// �� ����
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void getDelete(@RequestParam("idx") int idx, Model model) throws Exception {
		logger.info("get delete");

		model.addAttribute("delete", idx);

	}

//�� ����  POST 
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo) throws Exception {
		logger.info("post modify");

		System.out.println(vo);
		
		service.update(vo);
		
		return "redirect:/board/list";

	}

// �� ����  POST
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(@RequestParam("idx") int idx,
							@ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		logger.info("post delete");

		service.delete(idx);

		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}

	// �� ��� + ����¡
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
	
		logger.info("get list page");
	 
		 List<BoardVO> list = service.listPage(cri);
		 model.addAttribute("list", list);
		 
		 PageMaker pageMaker = new PageMaker();
		 pageMaker.setCri(cri);
		 pageMaker.setTotalCount(service.listCount());
		 model.addAttribute("pageMaker", pageMaker);
	 
	}
	// �� ��� + ����¡ + �˻�
	@RequestMapping(value = "/listSearch", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
	 logger.info("get list search");
	 
	 List<BoardVO> list = service.listSearch(scri);
	 model.addAttribute("list", list);
	 
	 PageMaker pageMaker = new PageMaker();
	 pageMaker.setCri(scri);
	 //pageMaker.setTotalCount(service.listCount());
	 pageMaker.setTotalCount(service.countSearch(scri));
	 model.addAttribute("pageMaker", pageMaker);
	}	

}
