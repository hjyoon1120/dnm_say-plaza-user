package com.dongnemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.PlazaDAO;
import com.dongnemon.dao.PlazaReplyDAO;
import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.PlazaReplyVO;

@Service
public class PlazaReplyServiceImpl implements PlazaReplyService {

	@Autowired
	private PlazaReplyDAO rDao;

	@Autowired
	private PlazaDAO pDao;

	@Transactional
	@Override
	public void addReply(PlazaReplyVO vo) throws Exception {
		rDao.create(vo);
		pDao.uptReplyCnt(vo.getPlaza_id(), 1);
	}

	@Override
	public void modifyReply(PlazaReplyVO vo) throws Exception {
		rDao.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer id) throws Exception {

		int plaza_id = rDao.getPlaza_id(id);
		rDao.delete(id);
		pDao.uptReplyCnt(plaza_id, -1);
	}

	@Override
	public List<PlazaReplyVO> listReply(Integer plaza_id) throws Exception {
		return rDao.list(plaza_id);
	}

	@Override
	public List<PlazaReplyVO> listReplyPage(Integer plaza_id, Criteria cri) throws Exception {

		return rDao.listPage(plaza_id, cri);
	}

	@Override
	public int cntReply(Integer plaza_id) throws Exception {

		return rDao.cntReply(plaza_id);
	}

}
