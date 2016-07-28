package com.dongnemon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PageMaker;
import com.dongnemon.domain.PlazaReplyVO;
import com.dongnemon.service.PlazaReplyService;

@RestController
@RequestMapping("/p_replies")
public class PlazaReplyController {

	@Autowired
	private PlazaReplyService service;

	// add plaza_reply
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody PlazaReplyVO vo) {

		ResponseEntity<String> entity = null;

		try {
			service.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// modify plaza_reply
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody PlazaReplyVO vo) {

		ResponseEntity<String> entity = null;
		try {
			vo.setId(id);
			service.modifyReply(vo);

			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// remove plaza_reply
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("id") Integer id) {

		ResponseEntity<String> entity = null;

		try {
			service.removeReply(id);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;

	}

	// show all plaza_reply list
	@RequestMapping(value = "/all/{plaza_id}", method = RequestMethod.GET)
	public ResponseEntity<List<PlazaReplyVO>> list(@PathVariable("plaza_id") Integer plaza_id) {

		ResponseEntity<List<PlazaReplyVO>> entity = null;

		try {
			entity = new ResponseEntity<>(service.listReply(plaza_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// show plaza_reply list with paging
	@RequestMapping(value = "/{plaza_id}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("plaza_id") Integer plaza_id,
			@PathVariable("page") Integer page) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Criteria cri = new Criteria();
			cri.setPage(page);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);

			Map<String, Object> map = new HashMap<String, Object>();
			List<PlazaReplyVO> list = service.listReplyPage(plaza_id, cri);

			map.put("list", list);

			int replyCnt = service.cntReply(plaza_id);
			pageMaker.setTotalCnt(replyCnt);

			map.put("pageMaker", pageMaker);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

}
