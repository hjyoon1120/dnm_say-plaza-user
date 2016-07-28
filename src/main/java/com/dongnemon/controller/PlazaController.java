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
import com.dongnemon.domain.PageMaker;
import com.dongnemon.domain.PlazaVO;
import com.dongnemon.service.PlazaService;

@Controller
@RequestMapping("/plaza/*")
public class PlazaController {

	private static final Logger logger = LoggerFactory.getLogger(PlazaController.class);

	@Autowired
	private PlazaService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(PlazaVO plaza, Model model) throws Exception {
		logger.info("plaza register get....");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(PlazaVO plaza, RedirectAttributes rttr) throws Exception {
		logger.info("plaza register post...");
		logger.info(plaza.toString());

		service.register(plaza);

		rttr.addFlashAttribute("msg", "reg");
		return "redirect:/plaza/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void plazaList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("show all plaza list with paging......");
		logger.info(cri.toString());

		model.addAttribute("list_topic", service.listTopic(cri));
		model.addAttribute("list_saying", service.listSaying(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCnt(service.cntPagingTopic(cri));

		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@RequestMapping(value ="/listTopic", method = RequestMethod.GET)
	public void plazaTopicList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("show all plaza topic list with paging... ");
		model.addAttribute("list_topic", service.listTopic(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCnt(service.cntPagingTopic(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value ="/listSaying", method = RequestMethod.GET)
	public void plazaSayingList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("show all plaza saying list with paging... ");
		model.addAttribute("list_saying", service.listSaying(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCnt(service.cntPagingTopic(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("id") int id, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("plazaVO", service.read(id));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("id") int id, Criteria cri, RedirectAttributes rttr) throws Exception {

		service.remove(id);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "del");

		return "redirect:/plaza/list";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("id") int id, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {
		model.addAttribute("plazaVO", service.read(id));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(PlazaVO plaza, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("plaza modify post........");
		System.out.println("MODIFY" + plaza);
		service.modify(plaza);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "mod");

		return "redirect:/plaza/list";
	}

	@RequestMapping("/getAttach/{plaza_id}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("plaza_id") Integer plaza_id) throws Exception {

		return service.getAttach(plaza_id);
	}
}
