package com.dongnemon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.MoimVO;
import com.dongnemon.domain.PageMaker;
import com.dongnemon.service.MoimService;

@Controller
@RequestMapping("/moim/*")
public class MoimController {

	private static final Logger logger = LoggerFactory.getLogger(MoimController.class);

	@Autowired
	private MoimService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(MoimVO moim, Model model) throws Exception {
		logger.info("moim register get....");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(MoimVO moim, RedirectAttributes rttr) throws Exception {
		logger.info("moim register post...");
		logger.info(moim.toString());

		service.register(moim);

		rttr.addFlashAttribute("msg", "reg");
		return "redirect:/moim/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void moimList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("show all moim list with paging......");
		logger.info(cri.toString());

		model.addAttribute("list", service.list(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCnt(service.cntPaging(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("id") int id, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("moimVO", service.read(id));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("id") int id, Criteria cri, RedirectAttributes rttr) throws Exception {

		service.remove(id);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "del");

		return "redirect:/moim/list";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("id") int id, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {
		model.addAttribute("moimVO", service.read(id));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(MoimVO moim, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("moim modify post........");
		System.out.println("MODIFY" + moim);
		service.modify(moim);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "mod");

		return "redirect:/moim/list";
	}

	@RequestMapping("/getAttach/{moim_id}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("moim_id") Integer moim_id) throws Exception {

		return service.getAttach(moim_id);
	}
}
