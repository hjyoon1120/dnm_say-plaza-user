package com.dongnemon.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.util.WebUtils;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PageMaker;
import com.dongnemon.domain.UserVO;
import com.dongnemon.dto.LoginDTO;
import com.dongnemon.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {

		UserVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("userVO", vo);

		if (dto.isUseCookie()) {
			int amount = 60 * 60 * 24 * 7;

			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));

			service.keepLogin(vo.getId(), session.getId(), sessionLimit);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		Object obj = session.getAttribute("login");

		if (obj != null) {
			UserVO vo = (UserVO) obj;

			session.removeAttribute("login");
			session.invalidate();

			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getId(), session.getId(), new Date());
			}
		}

		return "redirect:/";
	}

	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		System.out.println("register account get....");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo, Model model) throws Exception {

		service.register(vo);
		System.out.println("register account post ...");

		model.addAttribute("new", vo);
		return "redirect:/";
	}*/
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(UserVO vo, Model model) throws Exception {
		logger.info("register account get....");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo, RedirectAttributes rttr) throws Exception {
		
		logger.info("user register post......");
		logger.info(vo.toString());
		
		service.register(vo);
		
		rttr.addFlashAttribute("msg", "reg");
		return "redirect:/";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void userList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("show all user list with paging...");
		logger.info(cri.toString());

		model.addAttribute("list", service.list(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCnt(service.cntPaging(cri));

		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("id") int id, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("userVO", service.read(id));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("id") int id, Criteria cri, RedirectAttributes rttr) throws Exception {

		service.remove(id);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "del");

		return "redirect:/";

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("id") int id, @ModelAttribute("cri") Criteria cri, Model model)
			throws Exception {

		model.addAttribute("userVO", service.read(id));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(UserVO vo, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("user modify post......");
		System.out.println("MODIFY: " + vo);
		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerpageNum());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "mod");

		return "redirect:/";
	}

	@RequestMapping("/getAttach/{user_id}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("user_id") Integer user_id) throws Exception {
		return service.getAttach(user_id);
	}

}
