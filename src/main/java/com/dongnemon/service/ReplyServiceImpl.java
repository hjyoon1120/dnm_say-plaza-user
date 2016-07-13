package com.dongnemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongnemon.dao.BoardDAO;
import com.dongnemon.dao.ReplyDAO;
import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO rDao;

	@Autowired
	private BoardDAO bDao;

	@Transactional
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		rDao.create(vo);
		bDao.uptReplyCnt(vo.getBno(), 1);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		rDao.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {

		int bno = rDao.getBno(rno);
		rDao.delete(rno);
		bDao.uptReplyCnt(bno, -1);
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return rDao.list(bno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		return rDao.listPage(bno, cri);
	}

	@Override
	public int cntReply(Integer bno) throws Exception {
		return rDao.cntReply(bno);
	}
}
