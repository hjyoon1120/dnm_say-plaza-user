package com.dongnemon.dao;

import java.util.List;

import com.dongnemon.domain.Criteria;
import com.dongnemon.domain.ReplyVO;

public interface ReplyDAO {

	public void create(ReplyVO vo) throws Exception;

	public void update(ReplyVO vo) throws Exception;

	public void delete(Integer rno) throws Exception;
	
	public List<ReplyVO> list(Integer bno) throws Exception;
	
	public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception;
	
	public int cntReply(Integer bno) throws Exception;
	
	public int getBno(Integer rno) throws Exception;
}
