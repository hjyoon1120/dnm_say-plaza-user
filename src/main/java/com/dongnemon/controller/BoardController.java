package com.dongnemon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongnemon.domain.BoardVO;
import com.dongnemon.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {

		logger.info("board register get...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		logger.info("board register post....");
		logger.info(board.toString());

		service.register(board);

		rttr.addFlashAttribute("msg", "reg");

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {

		logger.info("show all list on board... ");
		model.addAttribute("list", service.listAll());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute("boardVO", service.read(bno));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		service.remove(bno);

		rttr.addFlashAttribute("msg", "del");

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute("boardVO", service.read(bno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		logger.info("board modify post...");

		service.modify(board);
		rttr.addFlashAttribute("msg", "mod");

		return "redirect:/board/list";
	}

}
