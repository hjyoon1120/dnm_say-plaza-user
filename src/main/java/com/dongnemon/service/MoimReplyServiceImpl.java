package com.dongnemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.MoimDAO;
import com.dongnemon.dao.MoimReplyDAO;
import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.MoimReplyVO;

@Service
public class MoimReplyServiceImpl implements MoimReplyService {

	@Autowired
	private MoimReplyDAO rDao;

	@Autowired
	private MoimDAO mDao;

	@Transactional
	@Override
	public void addReply(MoimReplyVO vo) throws Exception {
		rDao.create(vo);
		mDao.uptReplyCnt(vo.getMoim_id(), 1);
	}

	@Override
	public void modifyReply(MoimReplyVO vo) throws Exception {
		rDao.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer id) throws Exception {

		int moim_id = rDao.getMoim_id(id);
		rDao.delete(id);
		mDao.uptReplyCnt(moim_id, -1);
	}

	@Override
	public List<MoimReplyVO> listReply(Integer moim_id) throws Exception {
		return rDao.list(moim_id);
	}

	@Override
	public List<MoimReplyVO> listReplyPage(Integer moim_id, Criteria cri) throws Exception {

		return rDao.listPage(moim_id, cri);
	}

	@Override
	public int cntReply(Integer moim_id) throws Exception {

		return rDao.cntReply(moim_id);
	}

}
