package com.dongnemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.SayDAO;
import com.dongnemon.dao.SayReplyDAO;
import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.SayReplyVO;

@Service
public class SayReplyServiceImpl implements SayReplyService {

	@Autowired
	private SayReplyDAO rDao;

	@Autowired
	private SayDAO sDao;

	@Transactional
	@Override
	public void addReply(SayReplyVO vo) throws Exception {
		rDao.create(vo);
		sDao.uptReplyCnt(vo.getSay_id(), 1);
	}

	@Override
	public void modifyReply(SayReplyVO vo) throws Exception {
		rDao.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer id) throws Exception {

		int say_id = rDao.getSay_id(id);
		rDao.delete(id);
		sDao.uptReplyCnt(say_id, -1);
	}

	@Override
	public List<SayReplyVO> listReply(Integer say_id) throws Exception {
		return rDao.list(say_id);
	}

	@Override
	public List<SayReplyVO> listReplyPage(Integer say_id, Criteria cri) throws Exception {

		return rDao.listPage(say_id, cri);
	}

	@Override
	public int cntReply(Integer say_id) throws Exception {

		return rDao.cntReply(say_id);
	}

}
