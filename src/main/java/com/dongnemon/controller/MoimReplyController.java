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
import com.dongnemon.domain.MoimReplyVO;
import com.dongnemon.domain.PageMaker;
import com.dongnemon.service.MoimReplyService;

@RestController
@RequestMapping("/m_replies")
public class MoimReplyController {

	@Autowired
	private MoimReplyService service;

	// add moim_reply
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody MoimReplyVO vo) {

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

	// modify moim_reply
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody MoimReplyVO vo) {

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

	// remove moim_reply
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

	// show all moim_reply list
	@RequestMapping(value = "/all/{moim_id}", method = RequestMethod.GET)
	public ResponseEntity<List<MoimReplyVO>> list(@PathVariable("moim_id") Integer moim_id) {

		ResponseEntity<List<MoimReplyVO>> entity = null;

		try {
			entity = new ResponseEntity<>(service.listReply(moim_id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// show moim_reply list with paging
	@RequestMapping(value = "/{moim_id}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("moim_id") Integer moim_id,
			@PathVariable("page") Integer page) {

		ResponseEntity<Map<String, Object>> entity = null;

		try {
			Criteria cri = new Criteria();
			cri.setPage(page);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);

			Map<String, Object> map = new HashMap<String, Object>();
			List<MoimReplyVO> list = service.listReplyPage(moim_id, cri);

			map.put("list", list);

			int replyCnt = service.cntReply(moim_id);
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
