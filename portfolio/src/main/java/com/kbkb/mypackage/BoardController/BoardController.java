package com.kbkb.mypackage.BoardController;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kbkb.mypackage.domain.BoardVO;
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
	public void getRead(@RequestParam("idx") int idx, Model model) throws Exception {
		logger.info("get read");

		System.out.println(idx);

		BoardVO vo = service.read(idx);

		System.out.println(vo);

		model.addAttribute("read", vo);

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
	public String postDelete(@RequestParam("idx") int idx) throws Exception {
		logger.info("post delete");

		service.delete(idx);

		return "redirect:/board/list";
	}

}
